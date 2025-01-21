@echo off
setlocal enabledelayedexpansion

@REM Define paths
set "PROJECT_DIR=C:\.no-enemies\Study\S3-S5\atelier"
set "JAVA_HOME=C:\Compilers\jdk-17.0.13"
set "TOMCAT_HOME=C:\tomcat"
set "PATH=%JAVA_HOME%\bin;%PATH%"
set "TEMP_DIR=%PROJECT_DIR%\build"
set "WEBINF_LIB_DIR=%TEMP_DIR%\WEB-INF\lib"
set "TOMCAT_WEBAPPS=%TOMCAT_HOME%\webapps"
set "WAR_NAME=atelier.war"
set "JAR_EXECUTABLE=%JAVA_HOME%\bin\jar.exe"

@REM Use quotes when referencing paths with spaces
if not exist "%PROJECT_DIR%" (
    echo Project directory does not exist: %PROJECT_DIR%
    exit /b
)

@REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Java is not installed or not in PATH.
    exit /b 1
)

@REM Check if the project directory exists
if not exist "%PROJECT_DIR%" (
    echo Error: Project directory does not exist: %PROJECT_DIR%
    exit /b 1
)

@REM Create temporary directory for building WAR
if exist %TEMP_DIR% rmdir /s /q %TEMP_DIR%
mkdir %TEMP_DIR%
mkdir %TEMP_DIR%\WEB-INF
mkdir %TEMP_DIR%\WEB-INF\classes
mkdir %TEMP_DIR%\WEB-INF\lib
mkdir %TEMP_DIR%\pages

echo.
@REM Copy necessary files
echo Copying files...
copy "%PROJECT_DIR%\index.jsp" "%TEMP_DIR%" /y >nul
xcopy "%PROJECT_DIR%\lib" "%TEMP_DIR%\WEB-INF\lib%" /y >nul
xcopy "%PROJECT_DIR%\assets" "%TEMP_DIR%\assets" /E /I /Y >nul
xcopy "%PROJECT_DIR%\pages" "%TEMP_DIR%\pages" /y >nul
xcopy "%PROJECT_DIR%\conf" "%TEMP_DIR%\WEB-INF" /y >nul

echo.
@REM Compile all .java files in src\main\java (including subdirectories)
echo Compiling Java files...

for /R "%PROJECT_DIR%\src" %%f in (*.java) do (
    set "JAVA_FILES=!JAVA_FILES! %%f"
)

@REM We can add a classpath and say that we add specific libs (not all)
javac -sourcepath "%PROJECT_DIR%\src" -d "%TEMP_DIR%\WEB-INF\classes" -cp "%TEMP_DIR%\WEB-INF\lib\*" %JAVA_FILES%

if %errorlevel% neq 0 (
    echo Error: Compilation failed.
    exit /b 1
)

echo.
echo Compilation completed successfully!

echo.
@REM Create WAR file
echo Creating WAR file...
%JAR_EXECUTABLE% cvf %WAR_NAME% -C %TEMP_DIR% . >nul

@REM Remove temporary directory
rmdir /s /q %TEMP_DIR%
echo WAR file creation completed!

@REM Check if Tomcat webapps directory exists
if not exist "%TOMCAT_WEBAPPS%" (
    echo Error: Tomcat webapps %TOMCAT_WEBAPPS% directory does not exist.
    exit /b 1
)

@REM Remove old WAR file and deployed directory from Tomcat
echo Removing old version...
if exist "%TOMCAT_WEBAPPS%\%WAR_NAME%" del "%TOMCAT_WEBAPPS%\%WAR_NAME%"
if exist "%TOMCAT_WEBAPPS%\%WAR_NAME:~0,-4%" rmdir /s /q "%TOMCAT_WEBAPPS%\%WAR_NAME:~0,-4%"

@REM Copy new WAR file to Tomcat webapps directory
echo Deploying new WAR...
copy %WAR_NAME% "%TOMCAT_WEBAPPS%" >nul

if %errorlevel% equ 0 (
    echo WAR deployment to Tomcat completed successfully!
) else (
    echo Error during WAR deployment to Tomcat.
    exit /b 1
)

@REM Remove WAR file from the project directory
del %PROJECT_DIR%\%WAR_NAME%

echo.
echo Process completed. Please verify the deployment in Tomcat.

@REM Set CATALINA_HOME explicitly
set CATALINA_HOME=%TOMCAT_HOME%

@REM Start Tomcat using catalina.bat
echo Starting Tomcat...
call "%TOMCAT_HOME%\bin\catalina.bat" start
if %errorlevel% neq 0 (
    echo Error: Failed to start Tomcat.
    exit /b 1
)
echo Tomcat started successfully!
endlocal
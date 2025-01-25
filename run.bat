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

echo.
@REM Compile all .java files in src\main\java (including subdirectories)
echo Compiling Java files...

for /R "%PROJECT_DIR%\src" %%f in (*.java) do (
    set "JAVA_FILES=!JAVA_FILES! %%f"
)

@REM We can add a classpath and say that we add specific libs (not all)
javac -sourcepath "%PROJECT_DIR%\src" -d "%PROJECT_DIR%\bin" -cp "%PROJECT_DIR%\lib\*" %JAVA_FILES%

if %errorlevel% neq 0 (
    echo Error: Compilation failed.
    exit /b 1
)

echo.
echo Compilation completed successfully!

java -cp "%PROJECT_DIR%\lib\*;%PROJECT_DIR%\bin" test.TestGenericInsert
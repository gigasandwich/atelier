    @echo off

    REM Variables de configuration
    set "PROJECT_DIR=C:\Users\Ony\Desktop\template baovola"
    set "TOMCAT_WEBAPPS_DIR=C:\apache-tomcat-10.1.26\webapps"
    set "TOMCAT_BIN=C:\apache-tomcat-10.1.26\bin"
    set "WAR_NAME=Atelier.war"

    REM Naviguer vers le répertoire du projet
    cd /d "%PROJECT_DIR%"

    REM Nettoyer les anciennes classes compilées
    if exist build (
        rmdir /s /q build
    )
    mkdir build

    REM Compiler les fichiers Java
    echo Compilation des fichiers Java...
    javac -d build\WEB-INF\classes -cp "WEB-INF/lib/*;src" WEB-INF\src\connection\*.java WEB-INF\src\model\*.java WEB-INF\src\servlet\*.java

    REM Copier les fichiers JSP et autres ressources dans le répertoire de build
    echo Copie des fichiers JSP et ressources...
    xcopy /s /i pages\accueil\* build\pages\accueil\
    xcopy /s /i pages\insertion\* build\pages\insertion\

    REM Créer le répertoire WEB-INF/classes pour y copier les fichiers compilés
    mkdir build\WEB-INF\classes

    REM Copier les fichiers .class dans le répertoire WEB-INF\classes en respectant la structure des packages
    echo Copie des fichiers compiles dans WEB-INF/classes...
    xcopy /s /i build\connection\* build\WEB-INF\classes\connection
    xcopy /s /i build\model\* build\WEB-INF\classes\model
    xcopy /s /i build\servlet\* build\WEB-INF\classes\servlet

    REM Créer le fichier WAR
    echo Creation du fichier WAR...
    jar -cvf %WAR_NAME% -C build .

    REM Copier le fichier WAR dans le répertoire de déploiement de Tomcat
    echo Deploiement de l'application...
    copy %WAR_NAME% "%TOMCAT_WEBAPPS_DIR%"

    REM Redémarrer Tomcat pour prendre en compte le nouveau déploiement
    echo Redemarrage de Tomcat...
    cd /d "%TOMCAT_BIN%"
    call shutdown.bat
    call startup.bat

    echo Deploiement termine avec succes !
    pause

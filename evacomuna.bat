@echo off

set "JAVA_HOME=%~dp0..\"

echo Running evacomuna.jar...
"%JAVA_HOME%\bin\java" --module-path evacomuna\javafx-sdk-21\lib --add-modules javafx.controls,javafx.fxml -jar evacomuna\evacomuna.jar

if %ERRORLEVEL% EQU 0 (
  echo Execution complete.
) else (
  echo Execution failed.
)

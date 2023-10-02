@echo off

echo Running evacomuna.jar...
"%JAVA_HOME%\bin\java" --module-path "%JAVAFX_SDK%\lib" --add-modules javafx.controls,javafx.fxml -jar evacomuna\evacomuna.jar

if %ERRORLEVEL% EQU 0 (
  echo Execution complete.
) else (
  echo Execution failed.
)


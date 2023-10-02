@echo off

echo Running evacomuna.jar...
"%JAVA_HOME%\bin\java" --module-path "C:\Users\DanyG\repos\tarea-programacion-iii-2023\evacomuna\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml -jar evacomuna\evacomuna.jar

if %ERRORLEVEL% EQU 0 (
  echo Execution complete.
) else (
  echo Execution failed.
)


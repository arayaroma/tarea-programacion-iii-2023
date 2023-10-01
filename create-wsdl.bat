@echo off

REM Check if the script is called with a parameter
if "%~1"=="" (
  echo [!] Usage: %0 ^<ControllerName^>
  exit /b 1
)

set "controller_name=%~1"
set "base_url=http://localhost:8080/evacomunaws"
set "wsdl_endpoint=%controller_name%Controller?wsdl"
set "url=%base_url%/%wsdl_endpoint%"
set "output_directory=evacomuna\src\main\resources\cr\ac\una\evacomuna\wsdl"
set "output_file=%output_directory%\%controller_name%Service.wsdl"

mkdir "%output_directory%" 2>nul

curl -o "%output_file%" "%url%"

echo [+] Request from %url% -^> saved to %output_file%

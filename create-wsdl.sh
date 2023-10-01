#!/bin/bash

# Check if the script is called with a parameter
if [ $# -ne 1 ]; then
  echo "[!] Usage: $0 <ControllerName>"
  exit 1
fi

controller_name="$1"
base_url="http://localhost:8080/evacomunaws"
wsdl_endpoint="${controller_name}Controller?wsdl"
url="${base_url}/${wsdl_endpoint}"
output_directory="evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl"
output_file="${output_directory}/${controller_name}Service.wsdl"

mkdir -p "$output_directory"

curl -o "$output_file" "$url"

echo "[+] Request from $url -> saved to $output_file"

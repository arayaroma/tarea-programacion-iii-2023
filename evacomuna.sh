#!/bin/bash

JAVA_HOME=$(dirname "$(readlink -f "$(which java)")")/..

echo "Running evacomuna.jar..."
"$JAVA_HOME/bin/java" --module-path evacomuna/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml -jar evacomuna/evacomuna.jar

if [ $? -eq 0 ]; then
  echo "Execution complete."
else
  echo "Execution failed."
fi
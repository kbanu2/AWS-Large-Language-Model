#!/bin/bash

# Check if Java is installed
if ! brew list java &>/dev/null; then
    echo "Java is not installed. Installing now..."
    brew install java
fi

# Set the package prefix for the generated Java code
PACKAGE_PREFIX="org/example"

# Check if JacORB is downloaded
JACORB_VERSION="3.9"
JACORB_DIR="jacorb-$JACORB_VERSION"
if [ ! -d "$JACORB_DIR" ]; then
    echo "Downloading JacORB..."
    curl -OL https://www.jacorb.org/releases/$JACORB_VERSION/jacorb-$JACORB_VERSION-binary.zip
    unzip jacorb-$JACORB_VERSION-binary.zip
    rm jacorb-$JACORB_VERSION-binary.zip
fi

# Path to JacORB IDL compiler
JACORB_IDL="$JACORB_DIR/bin/idl"

# Check if the JacORB IDL compiler exists
if [ ! -x "$JACORB_IDL" ]; then
    echo "JacORB IDL compiler not found: $JACORB_IDL"
    exit 1
fi

# Compile IDL for Scala (generates Java code)
echo "Compiling IDL file..."
$JACORB_IDL -pkgPrefix TextProcessing $PACKAGE_PREFIX TextProcessing.idl

# Check if compilation was successful and files were generated
if [ $? -eq 0 ]; then
    echo "IDL compilation successful. Checking for generated files..."

    # Create a directory for the generated code
    mkdir -p src/main/java/$PACKAGE_PREFIX

    # Move generated files to the appropriate package directory
    mv $PACKAGE_PREFIX/* src/main/java/$PACKAGE_PREFIX/

    echo "Scala IDL compilation complete. Files organized into src/main/java/$PACKAGE_PREFIX directory."
else
    echo "IDL compilation failed."
fi

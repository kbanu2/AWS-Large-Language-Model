# Krenar Banushi kbanu2@uic.edu CS 441 Homework 1 Textbook Group 2 #

# Overview #
The DataProcessor project is designed to process text data, tokenize it, and generate embeddings using neural networks. This project is built using Scala for data processing and C++ for performance-critical tasks. The project employs deep learning libraries such as Deeplearning4j for building and training models, along with omniORB for communication in a distributed system.

## Features ##
Configuration Loading: Load configurations from a YAML file.
Text Processing: Split and tokenize text data into manageable chunks.
Embeddings Generation: Generate vector embeddings for words using a neural network.
Logging: Comprehensive logging for debugging and monitoring.

# Input and Output
## Input
Large Text File: The program takes as input a large text file that will be processed. The input data is split into chunks of 8192 bytes for efficient handling and processing.
## Output
CSV File: The output of the program is a CSV file containing statistics related to the processed text file. This includes:
A list of unique tokens generated from the text.
The frequency of each token within the input text.

## Prerequisites ##
Before running the program, ensure you have the following installed:

  Java Development Kit (JDK): Version 8 or later.
  Scala: Version 2.12 or later.
  SBT (Scala Build Tool): For managing dependencies and building the project.
  C++ Compiler: For compiling C++ components.
  Deeplearning4j: Ensure the Deeplearning4j library is included in your build.sbt.
  C++ Dependencies
Make sure to link against the necessary libraries, such as omniORB for the C++ components.

## Installation## 
### Clone the Repository ###

`git clone https://github.com/yourusername/DataProcessor.git`
`cd DataProcessor`

### Build the Project ###

Use SBT to build the Scala project:
`sbt clean compile`

## Running the Program ##
### Scala Component ###
Set Up the Configuration File

Create a YAML configuration file at src/main/resources/application.yaml with the necessary parameters, such as shardSize and embeddingDim.

### Run the Scala Program ###

To run the Scala program, execute the following command from the project root:
`sbt run`
This will start the Scala server which can be used by the C++ program for data processing


ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "DataProcessor",
    libraryDependencies += "com.knuddels" % "jtokkit" % "1.1.0",
    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies += "org.yaml" % "snakeyaml" % "2.0",
    libraryDependencies += "org.deeplearning4j" % "deeplearning4j-core" % "1.0.0-M2.1",
    libraryDependencies += "org.deeplearning4j" % "deeplearning4j-nlp" % "1.0.0-M1.1",
    libraryDependencies += "org.deeplearning4j" % "deeplearning4j-core" % "1.0.0-M1.1",
    libraryDependencies += "org.nd4j" % "nd4j-native" % "1.0.0-M2.1",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.5.6",
    libraryDependencies += "org.jacorb" % "jacorb" % "3.9"
  )

import sbt._
import sbt.Keys._
import scala.sys.process._

lazy val compileIDL = taskKey[Unit]("Compile IDL files")

compileIDL := {
    val idlFile = (baseDirectory.value / "src" / "main" / "resources" / "TextProcessing.idl").getAbsolutePath
    val jacorbIdlCommand = "jacorb_idl"

    // Check if jacorb_idl command is available
    val commandCheck = Process(s"which $jacorbIdlCommand").!
    if (commandCheck == 0) {
        // Run the jacorb_idl command
        val result = Process(s"$jacorbIdlCommand $idlFile").!
        if (result != 0) {
            throw new RuntimeException("Error compiling IDL file")
        } else {
            println("IDL compilation successful.")
        }
    } else {
        throw new RuntimeException(s"$jacorbIdlCommand not found in PATH")
    }
}

// Ensure the task runs before compiling Scala sources
compile in Compile := (compile in Compile).dependsOn(compileIDL).value

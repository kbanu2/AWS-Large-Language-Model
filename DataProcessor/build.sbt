ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "DataProcessor",
    libraryDependencies += "com.knuddels" % "jtokkit" % "1.1.0",
    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies += "org.yaml" % "snakeyaml" % "2.0",
      libraryDependencies += "org.deeplearning4j" % "deeplearning4j-core" % "1.0.0"
  )
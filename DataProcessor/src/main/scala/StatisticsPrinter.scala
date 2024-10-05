import java.io.{File, PrintWriter}

class StatisticsPrinter(dataProcessor: DataProcessor) {
  def printToConsole(): Unit = {
    println("Vocabulary Statistics:")
    dataProcessor.vocabulary.foreach { case (token, index) =>
      println(s"$token $index")
    }

    println("\nVocabulary Frequency:")
    dataProcessor.vocabFrequency.foreach { case (token, frequency) =>
      println(s"$token $frequency")
    }
  }

  def writeToCSV(filePath: String): Unit = {
    val writer = new PrintWriter(new File(filePath))

    // Writing Vocabulary
    writer.println("Token,Index")
    dataProcessor.vocabulary.foreach { case (token, index) =>
      writer.println(s"$token,$index")
    }

    // Writing Frequency
    writer.println("\nToken,Frequency")
    dataProcessor.vocabFrequency.foreach { case (token, frequency) =>
      writer.println(s"$token,$frequency")
    }

    writer.close()
  }
}
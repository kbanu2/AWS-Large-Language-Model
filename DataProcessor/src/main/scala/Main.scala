import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.api.ndarray.INDArray

object Main extends App {
  val configLoader = new ConfigLoader("DataProcessor/src/main/resources/application.yaml")
  val appConfig = configLoader.appConfig

  val textFile = appConfig("textFile").toString
  val shardSize = appConfig("shardSize").toString.toInt
  val embeddingDim = appConfig("embeddingDim").toString.toInt

  val dataProcessor = new DataProcessor(textFile, shardSize)
  val tokenizedSentences = dataProcessor.processFile()

  val totalTokens = tokenizedSentences.map(_.size()).sum // Total number of tokens
  val tokenizedArray = new Array[Array[Int]](totalTokens) // Create the array with the total number of tokens
  val labelsArray = new Array[Array[Int]](totalTokens)

  var index = 0 // Index to track the position in tokenizedArray
  for (i <- tokenizedSentences.indices) {
    for (j <- 0 until tokenizedSentences(i).size()) {
      tokenizedArray(index) = Array(tokenizedSentences(i).get(j)) // Create a new array for each token
      index += 1 // Increment the index for the next position
    }
  }

  for (i <- tokenizedArray.indices){
    if (i < tokenizedArray.length - 1)
      labelsArray(i) = tokenizedArray(i + 1)
    else
      labelsArray(i) = Array(0)
  }

  val inputFeatures: INDArray = Nd4j.create(tokenizedArray)
  val outputLabels: INDArray = Nd4j.create(labelsArray)
  val vocabSize = dataProcessor.vocabulary.size // Total number of unique tokens in your vocabulary (e.g., 1-9, plus 0 for padding)

  val modelTrainer = new ModelTrainer(vocabSize, embeddingDim, inputFeatures, outputLabels)
  modelTrainer.train()

  val embeddings = modelTrainer.getEmbeddings
  println("Learned Embeddings:\n" + embeddings)

  dataProcessor.vocabulary.foreachEntry((s, i) => {
    println(s + " " + i)
  })

  println()

  dataProcessor.vocabFrequency.foreachEntry((s, i) => {
    println(s + " " + i)
  })
}
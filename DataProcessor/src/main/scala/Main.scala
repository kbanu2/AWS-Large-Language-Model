import org.deeplearning4j.nn.conf.NeuralNetConfiguration
import org.yaml.snakeyaml.Yaml
import java.io.{File, FileInputStream}
import scala.jdk.CollectionConverters._
import org.nd4j.linalg.factory.Nd4j
import org.deeplearning4j.nn.conf.layers.{EmbeddingLayer, OutputLayer}
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.api.ndarray.INDArray
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork
import org.nd4j.linalg.lossfunctions.LossFunctions

object Main extends App {
  private val yaml = new Yaml()
  private val inputStream = new FileInputStream(new File("DataProcessor/src/main/resources/application.yaml"))
  private val configMap = yaml.load(inputStream).asInstanceOf[java.util.Map[String, Any]].asScala
  private val appConfig = configMap("app").asInstanceOf[java.util.Map[String, Any]].asScala

  private val textFile = appConfig("textFile").toString
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

  val config = new NeuralNetConfiguration.Builder()
    .list()
    .layer(new EmbeddingLayer.Builder()
      .nIn(vocabSize) // Input size (vocabulary size)
      .nOut(embeddingDim) // Output size (embedding dimensions)
      .activation(Activation.IDENTITY) // No activation function
      .build())
    .layer(new OutputLayer.Builder(LossFunctions.LossFunction.SPARSE_MCXENT) // Sparse cross-entropy for classification
      .nIn(embeddingDim)
      .nOut(vocabSize + 1) // Output is a probability distribution over the vocabulary
      .activation(Activation.SOFTMAX) // Softmax for next word prediction
      .build())
    .build()

  val model = new MultiLayerNetwork(config)
  val epoch = 100
  model.init()

  for (i <- 0 to epoch){
    model.fit(inputFeatures, outputLabels)
  }

  val embeddings = model.getLayer(0).getParam("W")
  System.out.println("Learned Embeddings:\n" + embeddings)

  dataProcessor.vocabulary.foreachEntry((s, i) => {
    println(s + " " + i)
  })

  println()

  dataProcessor.vocabFrequency.foreachEntry((s, i) => {
    println(s + " " + i)
  })
}
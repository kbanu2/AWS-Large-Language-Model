import org.deeplearning4j.nn.conf.{MultiLayerConfiguration, NeuralNetConfiguration}
import org.yaml.snakeyaml.Yaml

import java.io.{File, FileInputStream}
import scala.jdk.CollectionConverters._
import org.nd4j.linalg.factory.Nd4j
import org.deeplearning4j.nn.conf.layers.{EmbeddingLayer, OutputLayer}
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.api.ndarray.INDArray
import org.deeplearning4j.nn.conf.NeuralNetConfiguration
import org.deeplearning4j.nn.conf.MultiLayerConfiguration
import org.deeplearning4j.nn.conf.layers.EmbeddingLayer
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.lossfunctions.LossFunctions


object Main extends App {
  val yaml = new Yaml()
  val inputStream = new FileInputStream(new File("DataProcessor/src/main/resources/application.yaml"))
  val configMap = yaml.load(inputStream).asInstanceOf[java.util.Map[String, Any]].asScala
  val appConfig = configMap("app").asInstanceOf[java.util.Map[String, Any]].asScala

  val textFile = appConfig("textFile").toString
  val shardSize = appConfig("shardSize").toString.toInt

  val dataProcessor = new DataProcessor(textFile, shardSize)
  val tokenizedSentences = dataProcessor.processFile()

  val maxLength = tokenizedSentences.map(_.size()).max
  val tokenizedArray = tokenizedSentences.map { tokenList =>
    val array = new Array[Int](maxLength)
    for (i <- 0 until tokenList.size()) {
      array(i) = tokenList.get(i)
    }
    array
  }.toArray


  val labelsArray = tokenizedArray.map { sentence =>
    sentence.tail :+ 0 // Shift each sentence to the right for prediction task
  }

  val inputFeatures = Nd4j.create(tokenizedArray)
  val outputLabels = Nd4j.create(labelsArray)

  val vocabSize = 9 // Total number of unique tokens in your vocabulary (e.g., 1-9, plus 0 for padding)
  val embeddingDim = 5 // Size of the embedding vectors
  val numClasses = 3

  val config = new NeuralNetConfiguration.Builder()
    .list()
    .layer(new EmbeddingLayer.Builder()
      .nIn(vocabSize) // Input size (vocabulary size)
      .nOut(embeddingDim) // Output size (embedding dimensions)
      .activation(Activation.IDENTITY) // No activation function
      .build())
    .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
      .activation(Activation.SOFTMAX) // Activation function for classification
      .nIn(embeddingDim) // Input size from the previous layer
      .nOut(numClasses) // Number of output classes
      .build())
    .build()


  val model = new MultiLayerNetwork(config)
  model.init()
  val numEpochs = 1;  // Number of training epochs

  // ßmodel.fit(inputFeatures, outputLabels);


  val embeddings = model.getLayer(0).getParam("W")
  System.out.println("Learned Embeddings:\n" + embeddings)


  println(tokenizedSentences)
  println(dataProcessor.decodeTokens(tokenizedSentences))

}
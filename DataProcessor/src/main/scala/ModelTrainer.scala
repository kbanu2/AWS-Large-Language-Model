import org.deeplearning4j.nn.conf.NeuralNetConfiguration
import org.deeplearning4j.nn.conf.layers.{EmbeddingLayer, OutputLayer}
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.lossfunctions.LossFunctions

class ModelTrainer(vocabSize: Int, embeddingDim: Int, inputFeatures: INDArray, outputLabels: INDArray) {
  private val config = new NeuralNetConfiguration.Builder()
    .list()
    .layer(new EmbeddingLayer.Builder()
      .nIn(vocabSize)
      .nOut(embeddingDim)
      .activation(Activation.IDENTITY)
      .build())
    .layer(new OutputLayer.Builder(LossFunctions.LossFunction.SPARSE_MCXENT)
      .nIn(embeddingDim)
      .nOut(vocabSize + 1)
      .activation(Activation.SOFTMAX)
      .build())
    .build()

  private val model = new MultiLayerNetwork(config)
  private val epoch = 100

  def train(): Unit = {
    model.init()
    for (_ <- 0 until epoch) {
      model.fit(inputFeatures, outputLabels)
    }
  }

  def getEmbeddings: INDArray = {
    model.getLayer(0).getParam("W")
  }
}
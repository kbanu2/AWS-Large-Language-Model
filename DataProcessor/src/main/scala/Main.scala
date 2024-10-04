import org.yaml.snakeyaml.Yaml
import java.io.{File, FileInputStream}
import scala.jdk.CollectionConverters._


object Main extends App {
  val yaml = new Yaml()
  val inputStream = new FileInputStream(new File("DataProcessor/src/main/resources/application.yaml"))
  val configMap = yaml.load(inputStream).asInstanceOf[java.util.Map[String, Any]].asScala
  val appConfig = configMap("app").asInstanceOf[java.util.Map[String, Any]].asScala

  val textFile = appConfig("textFile").toString
  val shardSize = appConfig("shardSize").toString.toInt


  val text = "The quick brown fox jumps over the lazy dog"
  val processor = new DataProcessor(text, shardSize)

  val shards = processor.splitIntoShards()
  val encoded = processor.convertShardsToTokens(shards)
  val decoded = processor.decodeTokens(encoded)

  println(decoded)
}
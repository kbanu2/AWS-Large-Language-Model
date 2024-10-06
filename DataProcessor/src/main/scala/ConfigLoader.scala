import org.yaml.snakeyaml.Yaml
import java.io.{File, FileInputStream}
import scala.jdk.CollectionConverters.MapHasAsScala
import org.slf4j.{Logger, LoggerFactory}

// Class to load configuration from a YAML file
class ConfigLoader(filePath: String) {
  private val logger: Logger = LoggerFactory.getLogger(classOf[ConfigLoader])
  private val yaml = new Yaml()
  private val inputStream = new FileInputStream(new File(filePath))

  logger.info(s"Loading configuration from $filePath")

  private val configMap = yaml.load(inputStream).asInstanceOf[java.util.Map[String, Any]].asScala
  val appConfig: Map[String, Any] = configMap("app").asInstanceOf[java.util.Map[String, Any]].asScala.toMap

  logger.info("Configuration loaded successfully")
}

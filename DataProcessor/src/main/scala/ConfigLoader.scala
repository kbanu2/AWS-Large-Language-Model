import org.yaml.snakeyaml.Yaml
import java.io.{File, FileInputStream}
import scala.jdk.CollectionConverters.MapHasAsScala

class ConfigLoader(filePath: String) {
  private val yaml = new Yaml()
  private val inputStream = new FileInputStream(new File(filePath))
  private val configMap = yaml.load(inputStream).asInstanceOf[java.util.Map[String, Any]].asScala
  val appConfig: Map[String, Any] = configMap("app").asInstanceOf[java.util.Map[String, Any]].asScala.toMap
}
import com.knuddels.jtokkit.Encodings
import com.knuddels.jtokkit.api.{Encoding, EncodingType, IntArrayList}

class DataProcessor(text: String, shardSize: Int) {

  // Create a new EncodingRegistry and get an encoding type
  private val registry = Encodings.newDefaultEncodingRegistry()
  private val encoding: Encoding = registry.getEncoding(EncodingType.CL100K_BASE)

  // Split the text into shards for parallel processing
  def splitIntoShards(): Seq[String] = {
    text.split("\\s+").grouped(shardSize).map(_.mkString(" ")).toSeq
  }

  // Convert text shards into numerical tokens
  def convertShardsToTokens(shards: Seq[String]): Seq[IntArrayList] = {
    shards.map { shard =>
      encoding.encode(shard)  // Encodes each shard into numerical tokens
    }
  }

  // Decode numerical tokens back to text
  def decodeTokens(tokens: Seq[IntArrayList]): Seq[String] = {
    tokens.map { tokenList =>
      encoding.decode(tokenList)  // Decodes tokens back into the original text
    }
  }

  // Handle special tokens like [CLS] and [SEP] if needed
  def addSpecialTokens(tokens: IntArrayList): IntArrayList = {
    val clsToken = encoding.encode("[CLS]").get(0)
    val sepToken = encoding.encode("[SEP]").get(0)

    // Create a new IntArrayList to store tokens with special tokens added
    val updatedTokens = new IntArrayList()
    updatedTokens.add(clsToken)

    // Reasoning for using a for loop is that the Jtokkit IntArrayList does not seem to implement any iterable functions
    for (i <- 0 to tokens.size()){
      updatedTokens.add(tokens.get(i))
    }

    updatedTokens.add(sepToken)
    updatedTokens
  }
}


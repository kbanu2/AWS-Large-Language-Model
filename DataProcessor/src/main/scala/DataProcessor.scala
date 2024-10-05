import com.knuddels.jtokkit.Encodings
import com.knuddels.jtokkit.api.{Encoding, EncodingType, IntArrayList}

import java.io.{BufferedReader, FileReader}
import java.util

class DataProcessor(filePath: String, shardSize: Int) {

  // Create a new EncodingRegistry and get an encoding type
  private val registry = Encodings.newDefaultEncodingRegistry()
  private val encoding: Encoding = registry.getEncoding(EncodingType.CL100K_BASE)

  // Read the large file and return its content as a string
  // This method will handle large files efficiently
  def readFile(): util.Iterator[String] = {
    val bufferedReader = new BufferedReader(new FileReader(filePath))
    bufferedReader.lines().iterator()
  }

  // Process the file by reading, splitting into shards, and tokenizing
  def processFile(): Seq[IntArrayList] = {
    // Use StringBuilder to handle large text chunks
    val textBuilder = new StringBuilder()

    // Read and append chunks from the file
    readFile().forEachRemaining(line => textBuilder.append(line).append(" "))

    // Convert entire file content into a string for processing
    val textContent = textBuilder.toString()

    // Split the content into shards for parallel processing
    val shards = splitIntoShards(textContent)

    // Convert each shard into numerical tokens
    convertShardsToTokens(shards)
  }

  // Split the text into shards for parallel processing
  def splitIntoShards(text: String): Seq[String] = {
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


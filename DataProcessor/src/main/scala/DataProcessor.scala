import com.knuddels.jtokkit.Encodings
import com.knuddels.jtokkit.api.{Encoding, EncodingType, IntArrayList}

import java.io.{BufferedReader, FileReader}
import java.util
import scala.collection.mutable

class DataProcessor(filePath: String, shardSize: Int) {

  // Create a new EncodingRegistry and get an encoding type
  val vocabulary: mutable.TreeMap[String, Int] = mutable.TreeMap[String, Int]()
  val vocabFrequency: mutable.Map[String, Int] = mutable.Map[String, Int]()

  // Read the large file and return its content as a string
  // This method will handle large files efficiently
  def readFile(): util.Iterator[String] = {
    val bufferedReader = new BufferedReader(new FileReader(filePath))
    bufferedReader.lines().iterator()
  }


  // Process the file by reading, splitting into shards, and tokenizing
  def processFile(): Seq[IntArrayList] = {
    val textBuilder = new StringBuilder()

    readFile().forEachRemaining(line => textBuilder.append(line).append(" "))

    val textContent = textBuilder.toString()
    val shards = splitIntoShards(textContent)

    convertShardsToTokens(shards)
  }

  // Split the text into shards for parallel processing
  def splitIntoShards(text: String): Seq[String] = {
    text.split("\\s+").grouped(shardSize).map(_.mkString(" ")).toSeq
  }

  // Convert text shards into numerical tokens
  private def convertShardsToTokens(shards: Seq[String]): Seq[IntArrayList] = {
    shards.map { shard =>
      val tokens = shard.split("\\s+")
      val intArrayList = new IntArrayList()

      tokens.foreach { token =>

        // Add the token to the vocabulary if it does not exist
        val index = vocabulary.getOrElse(token, {
          // If the token is not in the vocabulary, add it with a new index
          val newIndex = vocabulary.size // Current size gives a unique index
          vocabulary += (token -> newIndex) // Add token to the vocabulary
          vocabFrequency += (token -> 0)
          newIndex // Return the new index
        })

        vocabFrequency(token) += 1
        intArrayList.add(index) // Add the token's index to the IntArrayList
      }

      intArrayList
    }
  }

  // Decode numerical tokens back to text
  def decodeTokens(tokens: Seq[IntArrayList]): Seq[String] = {
    tokens.map { tokenList =>
      val decodedTokens = (0 until tokenList.size()).map(i => {
        val tokenIndex = tokenList.get(i)
        vocabulary.find(_._2 == tokenIndex).map(_._1).getOrElse("[UNK]")
      })
      decodedTokens.mkString(" ")
    }
  }
//
//  // Handle special tokens like [CLS] and [SEP] if needed
//  def addSpecialTokens(tokens: IntArrayList): IntArrayList = {
//    val clsToken = encoding.encode("[CLS]").get(0)
//    val sepToken = encoding.encode("[SEP]").get(0)
//
//    // Create a new IntArrayList to store tokens with special tokens added
//    val updatedTokens = new IntArrayList()
//    updatedTokens.add(clsToken)
//
//    // Reasoning for using a for loop is that the Jtokkit IntArrayList does not seem to implement any iterable functions
//    for (i <- 0 to tokens.size()){
//      updatedTokens.add(tokens.get(i))
//    }
//
//    updatedTokens.add(sepToken)
//    updatedTokens
//  }
}


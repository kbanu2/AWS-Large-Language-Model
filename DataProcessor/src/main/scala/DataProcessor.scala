import com.knuddels.jtokkit.api.IntArrayList
import scala.collection.mutable

class DataProcessor(data: String, shardSize: Int) {

  // Create a new EncodingRegistry and get an encoding type
  val vocabulary: mutable.TreeMap[String, Int] = mutable.TreeMap[String, Int]()
  val vocabFrequency: mutable.Map[String, Int] = mutable.Map[String, Int]()

  // Process the input data by splitting into shards and tokenizing
  def processData(): Seq[IntArrayList] = {
    // Split the input data into shards
    val shards = splitIntoShards(data)
    // Convert shards into tokens
    convertShardsToTokens(shards)
  }

  // Split the text into shards for parallel processing
  def splitIntoShards(text: String): Seq[String] = {
    // Split the text into words and group them into shards
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
}

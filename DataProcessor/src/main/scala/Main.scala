class Main {


}

object Main extends App {
  val text = "The quick brown fox jumps over the lazy dog"
  val shardSize = 3
  val processor = new DataProcessor(text, shardSize)

  val shards = processor.splitIntoShards()
  val encoded = processor.convertShardsToTokens(shards)
  val decoded = processor.decodeTokens(encoded)

  println("Hello, DataProcessor!")
}
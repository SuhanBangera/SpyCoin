package blockchain

case class Miner(var reward: Double = Constants.MINER_REWARD) {

  def mine(block: Block): Unit = {
    while(notGoldenHash(block)) {
      block.generateHash
      block.incrementNonce()
    }
      println(block.toString + " was mined");
      println("Hash is : ", block.hash)
      Blockchain.addBlock(block)
      reward += Constants.MINER_REWARD;
  }

  private def notGoldenHash (block: Block): Boolean = {
    val leadingZeroes = new String(new Array[Char](Constants.DIFFICULTY)).replace('\u0000', '0')
    !block.hash.slice(0, Constants.DIFFICULTY).equals(leadingZeroes)
  }
}

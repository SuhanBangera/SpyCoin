package blockchain

object Blockchain {
  private var chain: Seq[Block] = Seq();

  def addBlock(block: Block): Unit = {
    chain :+= block
  }

  def getChain: Seq[Block] = chain;

  override def toString: String = {
    chain.mkString("->")
  }

}


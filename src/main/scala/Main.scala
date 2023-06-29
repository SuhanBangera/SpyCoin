import blockchain._

import scala.io.StdIn.{readChar, readLine}


object Main {
  def main (args: Array[String]) = {
    val miner = new Miner();
    val genesisBlock: Block = new Block(0, transaction = "transaction0", prevHash = Constants.GENESIS_PREV_HASH)

    miner.mine(genesisBlock);

    ask(miner)
  }

  private def ask (miner: Miner): Unit = {
    println("Do you want to add a block? (Y/N): ")
    val ans = readChar();

    ans match {
      case 'Y' | 'y' => {
        val data = readLine("Enter the Data you want to store: \n")
        miner.mine(new Block(id=Blockchain.getChain.last.id, transaction = data, prevHash = Blockchain.getChain.last.hash))
        ask(miner);
      };
      case _ => {
        println("\n \n Your Blockchain: ")
        println(Blockchain.toString)
        println("Thank You")
      }
    }
  }

}

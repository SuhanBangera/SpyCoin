package blockchain

import blockchain.Encrypt.createHash;

import java.sql.Timestamp
import java.time.Instant

case class Block(id: Int, transaction: String, var prevHash: String = null,  timestamp: Timestamp = Timestamp.from(Instant.now())) {
  var nonce = 0
     var hash: String = createHash(id.toString + nonce.toString + timestamp.toString + transaction.toString);

  def generateHash: Unit = hash = createHash(id.toString + nonce.toString + timestamp.toString + transaction.toString);
    def setPrevHash(hash: String): Unit = prevHash = hash;
    def incrementNonce (): Unit = nonce += 1;

  override def toString: String = this.id + "-" + this.transaction + "-" + this.hash + "-" + this.prevHash + "-";
}
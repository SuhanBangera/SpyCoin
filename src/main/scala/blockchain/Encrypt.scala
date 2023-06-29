package blockchain

import java.security.MessageDigest

object Encrypt {
  private val digest: MessageDigest = MessageDigest.getInstance(("SHA-256"));
  def createHash (text: String): String = digest.digest(text.getBytes("UTF-8")).map("%02x".format(_)).mkString;
}

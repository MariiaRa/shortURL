import akka.actor._

object MakeShortURLActor {
  def props: Props = Props[MakeShortURLActor]
  case class ValidURL(url: String)
  /*case class ShortURL(shortUrl: String)*/
}

class MakeShortURLActor extends Actor {
  import MakeShortURLActor._

  val alphabet: String = "bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ23456789-_"
  val randomStringLength = 8

  private def randomAlphaNumericString(chars: String): String = {
    val sb = new StringBuilder
    for (i <- 1 to randomStringLength) {
      val randomNum = util.Random.nextInt(chars.length)
      sb.append(chars(randomNum))
    }
    sb.toString
  }

  override def receive = {
    case ValidURL(url) => val shortName = "www.short-url/"+ randomAlphaNumericString(alphabet)
      println("Short url: " + shortName)
      sender ! ("Short url: " + shortName)
  }
}
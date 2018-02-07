import akka.actor._
import akka.testkit._
import org.specs2.mutable.SpecificationLike

class MakeShortURLActor extends Actor {

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
    case s: String => val shortName = "www.short-url/"+ randomAlphaNumericString(alphabet)
      sender ! shortName
  }
}


class MakeShortURLActorTest extends TestKit(ActorSystem()) with ImplicitSender with SpecificationLike {

  "An MakeShortURLActor actor" should {

    "send back string message" in {

      val testActor = system.actorOf(Props[MakeShortURLActor])
      val msg = "http://www.google.com"
      testActor ! msg
      val response = expectMsgType[String]
      response.length() should === (22)
      success
    }
  }

}

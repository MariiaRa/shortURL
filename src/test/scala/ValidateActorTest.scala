import java.util.regex.Pattern
import URLShortener.Args
import akka.actor._
import akka.testkit._
import org.specs2.mutable.SpecificationLike

class ValidateActor extends Actor {
  val urlPattern = "([A-Za-z]{3,9}:(?:\\/\\/)?)+([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*" +
    "((?!(10\\.|172\\.(1[6-9]|2\\d|3[01])\\.|192\\.168\\.).*)(?!255\\.255\\.255\\.255)" +
    "(25[0-5]|2[1,3]\\d|[1]\\d\\d|[1-9]\\d|[1-9])(\\.(25[0-5]|2[0-4]\\d|[1]\\d\\d|[1-9]\\d|\\d)){3}|" +
    "[^\\.\\-\\s]([a-zA-Z0-9-]+\\.)*[a-zA-Z0-9-]+\\." +
    "(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{1,9})|" +
    "(\\[(([\\da-fA-F]{4}(:|::)){1}([\\da-fA-F]{1,4}(:|::)){1,6}([:]{1,2})?" +
    "([\\da-fA-F]{1,4}){1})\\])|((?:\\+?(\\d{1}))?[- (](\\d{3})[- )](\\d{3})[- ](\\d{1,4})))(:[0-9]+)*" +
    "(\\/($|[a-zA-Z0-9\\.,\\?'\\\\\\+&%$#=~_\\-\\(\\)]+)?)*"
  def isValid(url: String): Boolean = Pattern.matches(urlPattern, url)

  def receive = {
    case x: Args =>
      if (isValid(x.string)) {
        sender ! "Valid url."
      } else {
        sender ! "Invalid url. Please, please provide a valid URL."
      }
  }
}


class ValidateActorTest extends TestKit(ActorSystem()) with ImplicitSender with SpecificationLike {

  "An Validate actor" should {

    "send back string message" in {

      val testActor = system.actorOf(Props[ValidateActor])
      val msg = Args("www.google.com")
      testActor ! msg
      expectMsg("Invalid url. Please, please provide a valid URL.")

      val msg1 = Args("http://www.google.com")
      testActor ! msg1
      expectMsg("Valid url.")
      success
    }
  }
}

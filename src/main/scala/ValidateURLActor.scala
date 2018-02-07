
import java.util.regex.Pattern

import URLShortener.Args
import akka.actor._

  object ValidateURLActor {
    def props(makeShortURLActor: ActorRef): Props = Props(new ValidateURLActor(makeShortURLActor))

    val urlPattern = "([A-Za-z]{3,9}:(?:\\/\\/)?)+([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*" +
                      "((?!(10\\.|172\\.(1[6-9]|2\\d|3[01])\\.|192\\.168\\.).*)(?!255\\.255\\.255\\.255)" +
                      "(25[0-5]|2[1,3]\\d|[1]\\d\\d|[1-9]\\d|[1-9])(\\.(25[0-5]|2[0-4]\\d|[1]\\d\\d|[1-9]\\d|\\d)){3}|" +
                      "[^\\.\\-\\s]([a-zA-Z0-9-]+\\.)*[a-zA-Z0-9-]+\\." +
                      "(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{1,9})|" +
                      "(\\[(([\\da-fA-F]{4}(:|::)){1}([\\da-fA-F]{1,4}(:|::)){1,6}([:]{1,2})?" +
                      "([\\da-fA-F]{1,4}){1})\\])|((?:\\+?(\\d{1}))?[- (](\\d{3})[- )](\\d{3})[- ](\\d{1,4})))(:[0-9]+)*" +
                      "(\\/($|[a-zA-Z0-9\\.,\\?'\\\\\\+&%$#=~_\\-\\(\\)]+)?)*"
  }

  class ValidateURLActor(makeShortURLActor: ActorRef) extends Actor {
    import MakeShortURLActor._
    import ValidateURLActor._


    def isValid(url: String): Boolean = Pattern.matches(urlPattern, url)

    def receive = {
      case x: Args =>
        if (isValid(x.string)) {
          println("Valid url.")
          makeShortURLActor ! ValidURL(x.string)
        } else {
          println("Invalid url. Please, please provide a valid URL.")
        }
    }
  }


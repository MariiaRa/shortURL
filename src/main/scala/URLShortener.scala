import ValidateURLActor._
import akka.actor._

object URLShortener {
  case class Args(string: String)

  def main(args: Array[String]): Unit = {
    // Create the 'URLShortener' actor system
    val system = ActorSystem("URLShortener")
    // Create the actor to generate short name
    val urlShortner: ActorRef = system.actorOf(MakeShortURLActor.props, "urlShortnerActor")
    // Create the actor to validate input URL
    val validator: ActorRef = system.actorOf(props(urlShortner), "validatorActor")

    if (args.length == 0) println("No URL, please provide a valid URL.")
    else validator ! Args(args(0))
  }
}

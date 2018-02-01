import java.util.regex.Pattern

object URLReadInput {

  val urlPattern = "(([:]*[A-Za-z]{3,9}:((?:\\/\\/)[\\[:\\d\\w\\]]*)?)((?:\\+?(\\d{1,3}))?[-. (]" +
                   "(\\d{1,3})[-. )](\\d{1,3})[-. ]*(\\d{1,4})[-. :](\\d{1,4})[\\/]*)?" +
                   "((?:[\\-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9\\.\\-]+|(?:www\\.|[\\-;:&=\\+\\$,\\w]+@)" +
                   "([A-Za-z0-9\\.\\-]+ )?)?((?:\\/[\\+~%\\/\\.\\w\\-:]*)?" +
                   "\\??(?:[\\(\\)\\?\\-\\+=&;%@\\.\\w]*)#?(?:[\\.\\!\\/\\w-:]*))?)"

  private def isValid(url:String): Boolean = Pattern.matches(urlPattern, url)

  def main(args: Array[String]): Unit = {
    if (args.length == 0){
      println("No URL, please provide a valid URL.")
    } else {
      isValid(args(0)) match {
        case true => println("www.short-url/" + scala.util.Random.nextInt(100))
        case false => println("Not a valid url")
      }
    }
  }
}

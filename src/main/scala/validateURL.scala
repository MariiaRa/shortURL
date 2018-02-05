import java.util.regex.Pattern

class validateURL{

  val urlPattern = "([A-Za-z]{3,9}:(?:\\/\\/)?)*([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*" +
    "((?!(10\\.|172\\.(1[6-9]|2\\d|3[01])\\.|192\\.168\\.).*)(?!255\\.255\\.255\\.255)" +
    "(25[0-5]|2[1,3]\\d|[1]\\d\\d|[1-9]\\d|[1-9])(\\.(25[0-5]|2[0-4]\\d|[1]\\d\\d|[1-9]\\d|\\d)){3}|" +
    "[^\\.\\-\\s]([a-zA-Z0-9-]+\\.)*[a-zA-Z0-9-]+\\." +
    "(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{1,9})|" +
    "(\\[(([\\da-fA-F]{4}(:|::)){1}([\\da-fA-F]{1,4}(:|::)){1,6}([:]{1,2})?" +
    "([\\da-fA-F]{1,4}){1})\\])|((?:\\+?(\\d{1}))?[- (](\\d{3})[- )](\\d{3})[- ](\\d{1,4})))(:[0-9]+)*" +
    "(\\/($|[a-zA-Z0-9\\.,\\?'\\\\\\+&%$#=~_\\-\\(\\)]+)?)*"

  private def isValid(url: String): Boolean = Pattern.matches(urlPattern, url)

  def test(url: String): String = {
    if (url.length == 0) {
      "No URL, please provide a valid URL."
    } else {
      isValid(url) match {
        case true => "Valid"
        case false => "Invalid"
      }
    }
  }
}
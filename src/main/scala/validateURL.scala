import java.util.regex.Pattern

class ShortURL{

  private def isValid(url: String): Boolean = Pattern.matches(URLReadInput.urlPattern, url)

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
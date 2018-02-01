import java.util.regex.Pattern

class ShortURL{

  private def isValid(url: String): Boolean = {
    Pattern.matches(URLReadInput.urlPattern, url)
  }

  def test(url: String): Either[String, Boolean] = {
    if(url.length == 0){
      Left("No URL, please provide a valid URL.")
    }else{
      Right(isValid(url))
    }
  }
}
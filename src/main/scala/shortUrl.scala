import java.util.regex.Pattern

class shortURL{

  val urlPattern = "(([:]*[A-Za-z]{3,9}:((?:\\/\\/)[\\[:\\d\\w\\]]*)?)((?:\\+?(\\d{1,3}))?[-. (](\\d{1,3})[-. )](\\d{1,3})[-. ]*(\\d{1,4})[-. :](\\d{1,4})[\\/]*)?((?:[\\-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9\\.\\-]+|(?:www\\.|[\\-;:&=\\+\\$,\\w]+@)( [A-Za-z0-9\\.\\-]+ )?)?((?:\\/[\\+~%\\/\\.\\w\\-:]*)?\\??(?:[\\(\\)\\?\\-\\+=&;%@\\.\\w]*)#?(?:[\\.\\!\\/\\w-:]*))?)"


  private def isValid(url:String):Boolean = {
    Pattern.matches(urlPattern, url)
  }

  def test(url: String): Either[String, Boolean] = {
    if(url.length == 0){
      Left("No URL, please provide a valid URL.")
    }else{
      Right(isValid(url))
    }
  }
}
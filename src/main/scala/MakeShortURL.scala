class MakeShortURL {

  val urlMap = collection.mutable.Map[String, String]()
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

  private def findKeyByValue(map: collection.mutable.Map[String, String], value: String): String = {
    map.filter{ case (k, v) => v == value }.keys.mkString
  }

  def encode(url: String): String = {
    if (urlMap.exists(_._2==url)){
      findKeyByValue(urlMap, url)
    } else {
      var shortName = "www.short-url/"+ randomAlphaNumericString(alphabet)
      urlMap += shortName -> url
      shortName
    }
  }

  def makeMap (list: List[String]): collection.mutable.Map[String, String] = {
    list.foreach(url => (encode(url)))
    urlMap
  }
}

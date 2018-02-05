class makeShortURLTest extends org.specs2.mutable.Specification{

  "A makeShortURL" should {
    """have an encode method that takes a valid URL
       and turns it into a short string and put into map """ in {

      val shortener = new makeShortURL
      val listOfvalidURLs = List[String](
        "https://www.google.com",
        "htttp://www.i.ua",
        "ftp://ftp.is.co.za/rfc/rfc1808.txthppt",
        "tel:+1-816-555-1212",
        "http://foo.com/blah_blah",
        "http://foo.com/blah_blah/",
        "http://foo.com/blah_blah_(wikipedia)",
        "https://www.google.com",
        "htttp://www.i.ua"
      )
      val map = shortener.makeMap(listOfvalidURLs)

      map must containMatch("www.short-url/")
      map must haveValue("htttp://www.i.ua")
      map must haveValue("https://www.google.com")
      map must haveValues(
        "https://www.google.com",
        "htttp://www.i.ua",
        "ftp://ftp.is.co.za/rfc/rfc1808.txthppt",
        "tel:+1-816-555-1212",
        "http://foo.com/blah_blah",
        "http://foo.com/blah_blah/",
        "http://foo.com/blah_blah_(wikipedia)"
      )
      map must have size 7
    }
  }
}

import org.specs2.specification.core.Fragments

class shortURLSpec3 extends org.specs2.mutable.Specification{


  val x = new shortURL
  val listOfvalidURLs = List[String] ("https://www.google.com", "htttp://www.i.ua", "ftp://ftp.is.co.za/rfc/rfc1808.txthppt", "tel:+1-816-555-1212", "http://foo.com/blah_blah",
  "http://foo.com/blah_blah/", "http://foo.com/blah_blah_(wikipedia)", "http://foo.com/blah_blah_(wikipedia)_(again)", "http://www.example.com/wpstyle/?p=364",
    "https://www.example.com/foo/?bar=baz&inga=42&quux", "http://userid:password@example.com:8080","ftp://ftp.is.co.za/rfc/rfc1808.txt", "http://www.ietf.org/rfc/rfc2396.txt",
"ldap://[2001:db8::7]/c=GB?objectClass?one", "mailto:John.Doe@example.com", "news:comp.infosystems.www.servers.unix", "tel:+1-816-555-1212", "telnet://192.0.2.16:80/",
"urn:oasis:names:specification:docbook:dtd:xml:4.1.2")

 /* val tested = for(url <- listOfURLs)yield x.test(url)*/

/*  "a list of urls must must be Right(true)" >> {
    listOfURLs foreach { url =>
      ("is valid: " + url) >> {
        x.test(url) must beRight(true)
      }
    }
  }*/

  listOfvalidURLs.foldLeft(Fragments.empty)((res, url) => res.append("example "+url ! { x.test(url) must beRight(true) }))

}

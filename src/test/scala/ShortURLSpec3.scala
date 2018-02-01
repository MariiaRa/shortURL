import org.specs2.specification.core.Fragments

class ShortURLSpec3 extends org.specs2.mutable.Specification{

  val x = new ShortURL
  val listOfvalidURLs = List[String](
    "https://www.google.com",
    "htttp://www.i.ua",
    "ftp://ftp.is.co.za/rfc/rfc1808.txthppt",
    "tel:+1-816-555-1212", "http://foo.com/blah_blah",
    "http://foo.com/blah_blah/",
    "http://foo.com/blah_blah_(wikipedia)",
    "http://foo.com/blah_blah_(wikipedia)_(again)",
    "http://www.example.com/wpstyle/?p=364",
    "https://www.example.com/foo/?bar=baz&inga=42&quux",
    "http://userid:password@example.com:8080",
    "ftp://ftp.is.co.za/rfc/rfc1808.txt",
    "http://www.ietf.org/rfc/rfc2396.txt",
    "ldap://[2001:db8::7]/c=GB?objectClass?one",
    "mailto:John.Doe@example.com",
    "news:comp.infosystems.www.servers.unix",
    "tel:+1-816-555-1212",
    "telnet://192.0.2.16:80/",
    "urn:oasis:names:specification:docbook:dtd:xml:4.1.2")

  val listOfInvalidUrls = List[String](
    "http://",
    "http://.",
    "http://..",
    "http://../",
    "http://?",
    "http://??",
    "http://foo.bar?q=Spaces",
    "///a",
    "http:// shouldfail.com",
    ":// should fail",
    "http://foo.bar/foo(bar)baz quux",
    "http://-error-.invalid/",
    "http://a.b--c.de/",
    "http://-a.b.co",
    "http://a.b-.co",
    "http://0.0.0.0",
    "http://10.1.1.0",
    "http://10.1.1.255",
    "http://224.1.1.1",
    "http://1.1.1.1.1",
    "http://123.123.123",
    "http://3628126748",
    "http://.www.foo.bar/",
    "http://www.foo.bar./",
    "http://.www.foo.bar./",
    "http://10.1.1.1",
    "http://10.1.1.254")

  listOfvalidURLs.foldLeft(Fragments.empty)((res, url) => res.append("url "+url+ " is valid" ! { x.test(url) must beRight(true) }))
  listOfInvalidUrls.foldLeft(Fragments.empty)((res, url) => res.append("url "+url+ " is invalid" ! { x.test(url) must beRight(false) }))

}

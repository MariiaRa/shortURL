import org.specs2._
import org.specs2.specification.core.SpecStructure

class shortURLSpec extends Specification{

  val x = new shortURL
  /*val listOfURLs = List[String] ("https://www.google.com", "htttp://www.i.ua", "ftp://ftp.is.co.za/rfc/rfc1808.txthppt", "tel:+1-816-555-1212")*/

  override def is: SpecStructure = s2"""

 this is my specification
   where url "https://www.google.com" must be Right(true)           $e1
   where url "www.google.com" must be Right(false)                  $e2
   where url "" must be Left("No URL, please provide a valid URL.") $e3
                                                             """

  def e1 = x.test("https://www.google.com") must beRight(true)
  def e2 = x.test("www.google.com") must_== Right(false)
  def e3 = x.test("") must_== Left("No URL, please provide a valid URL.")

}

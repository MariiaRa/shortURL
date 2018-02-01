import org.specs2._
import org.specs2.specification.core.SpecStructure

class shortURLSpec extends Specification{

  val x = new shortURL

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

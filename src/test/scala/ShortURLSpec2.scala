/*Unit specification*/
class ShortURLSpec2 extends org.specs2.mutable.Specification{

  val x = new validateURL

  /*"this is my specification" >> {
    """where example 1 "https://www.google.com" must be Right(true)""" >> {
      x.test("https://www.google.com") must_== Right(true)
    }
    """where url "www.google.com" must be Right(false)""" >> {
      x.test("www.google.com") must_== Right(false)
    }
    """where url "" must be Left("No URL, please provide a valid URL.")""" >> {
      x.test("") must_== Left("No URL, please provide a valid URL.")
    }
  }*/

  "This is my example" >> {
    x.test("https://www.google.com") must_== "Valid" // this fails
    x.test("www.google.com") must_== "Invalid"// this is not executed
    x.test("") must_== "No URL, please provide a valid URL."
  }
}
#!/bin/sh
exec scala "$0" "$@"
!#

object URLReadInput{

  val urlPattern = "([A-Za-z]{3,9}:(?:\\/\\/)?)([A-Za-z]){3,9}.([A-Za-z]){3,9}.([A-Za-z]){3,9}"
  def isValid(url:String):Boolean = url.matches(urlPattern)


  def main(args: Array[String]): Unit = {
    if(args.length == 0){
      println("No URL, please provide a valid URL.")
    }else{
     isValid(args(0)) match {
       case true => println("Your short url: www.short-url/" + scala.util.Random.nextInt(100))
       case false => println("Not a valid url")
     }
    }
  }
}


URLReadInput.main(args)

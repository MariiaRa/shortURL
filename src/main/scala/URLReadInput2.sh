#!/bin/sh
exec scala "$0" "$@"
!#

object URLReadInput2 {
  def main(args: Array[String]): Unit = {

    println("Please provide a valid URL.")

    val inputURL = scala.io.StdIn.readLine()

    if(inputURL.isEmpty){
      println("No URL, please provide a valid URL.")
    }else{
      println(inputURL)
    }


  }
}

URLReadInput2.main(args)

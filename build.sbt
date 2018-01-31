name := "URLShortener"
organization := "software.sigma"
version := "0.1"
scalaVersion := "2.12.4"

//testing
libraryDependencies += "org.specs2" %% "specs2-core" % "4.0.2" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")


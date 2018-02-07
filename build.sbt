name := "URLShortener"
organization := "software.sigma"
version := "0.1"
scalaVersion := "2.12.4"

//akka actors
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.9" % Test
)
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
//testing
libraryDependencies += "org.specs2" %% "specs2-core" % "4.0.2" % "test"
//resolvers are alternate resources provided for the projects on which there is a dependency
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"


scalacOptions in Test ++= Seq("-Yrangepos")


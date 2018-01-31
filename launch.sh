#!/bin/sh
sbt assembly
java -jar target/scala-2.12/URLShortener-assembly-0.1.jar $1


#!/bin/sh
mkdir -p src/{main,test}/{java,resources,scala}
mkdir lib project target

# create an initial build.sbt file
echo 'name := "URLShortener"
version := "0.1"
scalaVersion := "2.12.4"' > build.sbt

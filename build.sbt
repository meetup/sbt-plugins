
version := "make -s version".!!.trim

scalaVersion := "2.10.6"

sbtPlugin := true

scalacOptions := Seq(
  "-encoding", "utf8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xmax-classfile-name", "242")

name := "sbt-plugins"

organization := "com.meetup"

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

import sbt.Opts.compile

version := "make -s version".!!.trim

scalaVersion := "2.10.6"

sbtPlugin := true

scalacOptions := Seq(
  "-feature",
  compile.unchecked,
  compile.deprecation,
  // Needed for AUFS file systems.
  "-Xmax-classfile-name", "242") ++
  compile.encoding("UTF8")

name := "sbt-plugins"

organization := "com.meetup"

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

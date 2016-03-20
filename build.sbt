
enablePlugins(CommonSettingsPlugin)
enablePlugins(ScalariformPlugin)
enablePlugins(NexusPlugin)

name := "sbt-plugins"

scalaVersion := "2.10.6"

sbtPlugin := true

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

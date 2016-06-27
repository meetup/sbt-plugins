// comment.
enablePlugins(CommonSettingsPlugin)
enablePlugins(NexusPlugin)

name := "sbt-plugins"

scalaVersion := "2.10.6"

sbtPlugin := true

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

parallelExecution in CommonSettingsPlugin.ComponentTest := false

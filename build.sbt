
enablePlugins(CommonSettingsPlugin)

name := "sbt-plugins"

scalaVersion := "2.10.6"

sbtPlugin := true

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

parallelExecution in CommonSettingsPlugin.ComponentTest := false

resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"

bintrayOrganization in ThisBuild := Some("meetup")


enablePlugins(CommonSettingsPlugin)
enablePlugins(ScalariformPlugin)
enablePlugins(NexusPlugin)

name := "sbt-plugins"

scalaVersion := "2.10.6"

sbtPlugin := true

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")

lazy val root = (project in file("."))
  .configs(IntegrationTest)

Defaults.itSettings

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "it",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "it"
)

name := "sbt-plugins"

scalaVersion := "2.10.6"
sbtPlugin := true

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.6")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

ThisBuild / githubOwner := "meetup"
ThisBuild / githubRepository := "meetup"
ThisBuild / githubTokenSource := TokenSource.Environment("GITHUB_TOKEN")

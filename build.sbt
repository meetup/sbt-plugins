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

resolvers += "Nexus" at "https://nexus.blt.meetup.com/content/repositories/releases"

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val version = v.trim.toLowerCase
  // might be snapshot, might be build from the CI pipeline.
  val snapshot = v.contains("snapshot") || v.contains("build")

  val name = if(snapshot) "snapshots" else "releases"
  Some(name at s"https://nexus.blt.meetup.com/content/repositories/$name")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

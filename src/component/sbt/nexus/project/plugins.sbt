
// Grab version from root project.
val projectDir = file("./../../../..")
val projectVersion = s"make -s -C $projectDir version".!!.trim

addSbtPlugin("com.meetup" % "sbt-plugins" % projectVersion)

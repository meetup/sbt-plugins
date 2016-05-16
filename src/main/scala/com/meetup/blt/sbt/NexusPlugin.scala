package com.meetup.blt.sbt

import sbt._
import sbt.Keys._

/**
 * Nexus settings for a library project publishing to Nexus.
 */
object NexusPlugin extends AutoPlugin {
  val Nexus = "https://nexus.blt.meetup.com"

  override def projectSettings: Seq[Setting[_]] = Seq(
    publishMavenStyle := true,
    publishTo <<= version { (v: String) =>
      val version = v.trim.toLowerCase
      // might be snapshot, might be build from the CI pipeline.
      val snapshot = version.contains("snapshot") || version.contains("build")

      val name = if (snapshot) "snapshots" else "releases"
      Some(name at s"$Nexus/content/repositories/$name")
    },
    // Needed for accessing projects from nexus.blt.meetup.com.
    // Leaving here incase someone is publishing but doesn't
    // use CommonSettingsPlugin.
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )
}

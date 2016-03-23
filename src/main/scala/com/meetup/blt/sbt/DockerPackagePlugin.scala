package com.meetup.blt.sbt

import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.docker.{DockerPlugin => SbtDockerPlugin}
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import sbt._
import sbt.Keys._

/**
 * Some general build settings to do docker easily.
 */
object DockerPackagePlugin extends AutoPlugin {
  override def requires: Plugins = SbtDockerPlugin && JavaAppPackaging

  publishLocal in Docker <<= (publishLocal in Docker).dependsOn(test in Test)

  dockerTarget in Docker := "make -s publish-tag".!!.trim

  dockerBaseImage := "make -s base-tag".!!.trim
}

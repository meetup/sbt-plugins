package com.meetup.blt.sbt

import sbt.Opts.compile
import sbt.Keys._
import sbt._

object CommonSettingsPlugin extends AutoPlugin {

  override def projectSettings: Seq[Setting[_]] = Seq(
    organization in Global := "com.meetup",
    scalaVersion in Global := "2.11.7",
    // Grab version from Make build.properties so we're not managing
    // it in multiple places.
    version := "make -s version".!!.trim,
    updateOptions := updateOptions.value.withCachedResolution(true),
    scalacOptions in Global := Seq(
      "-feature",
      compile.unchecked,
      compile.deprecation,
      // Needed for AUFS file systems.
      "-Xmax-classfile-name", "242") ++
      compile.encoding("UTF8"),
    javacOptions in Global := Seq(
      "-g",
      "-source", "1.8",
      "-target", "1.8",
      "-encoding", "UTF-8" ),

    // Some basic libraries to get people started.
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"
    )
  )

}

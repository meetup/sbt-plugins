package com.meetup.blt.sbt

import sbt.Opts.compile
import sbt.Keys._
import sbt._

object CommonSettingsPlugin extends AutoPlugin {

  override def projectSettings: Seq[Setting[_]] = Seq(
    organization in Global := "com.meetup",
    // Grab version from Make build.properties so we're not managing
    // it in multiple places.
    scalaVersion in Global := "2.11.7",
    version := "make -s version".!!.trim,
    incOptions := incOptions.value.withNameHashing(true),
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
      "-encoding", "UTF-8" )
  )

}

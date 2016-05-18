package com.meetup.blt.sbt

import java.io.File

import scala.sys.process.Process

/**
  * Common methods used in these tests.
  */
class Sbt(baseDir: File) {

  def apply(commands: String*): String = {
    Process(Seq("sbt", "-Dsbt.log.noformat=true") ++ commands, baseDir).!!.trim
  }

  def runWith(env: Map[String, String], commands: String*): String = {
    Process(Seq("sbt", "-Dsbt.log.noformat=true") ++ commands, baseDir, env.toList: _*).!!.trim
  }

  def lastLine(commands: String*) = apply(commands: _*).split("\n").last

  def secondToLast(commands: String*) = apply(commands: _*).split("\n").reverse(1)
}

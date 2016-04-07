package com.meetup.blt.sbt

import java.io.File

import scala.sys.process.Process

/**
  * Common methods used in these tests.
  */
class Sbt(baseDir: File) {

  def apply(commands: String*): String = {
    Process(Seq("sbt") ++ commands, baseDir).!!.trim
  }

  def lastLine(commands: String*) = apply(commands: _*).split("\n").last

  def secondToLast(commands: String*) = apply(commands: _*).split("\n").reverse(1)
}

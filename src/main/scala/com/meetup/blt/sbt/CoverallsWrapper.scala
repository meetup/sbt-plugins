package com.meetup.blt.sbt

import org.scoverage.coveralls.CoverallsPlugin
import sbt._
import sbt.Keys._

object CoverallsWrapper extends AutoPlugin {
  override def requires: Plugins = CoverallsPlugin

  override def projectSettings: Seq[Setting[_]] = Seq(
    commands += Command.command("coverallsMaybe") { state: State =>
      if (sys.env.contains("COVERALLS_REPO_TOKEN")) {
        CoverallsPlugin.doCoveralls(state)
        state
      } else {
        println("No token for coveralls configured, passing.")
        state
      }
    }
  )

}

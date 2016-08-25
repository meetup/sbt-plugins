package com.meetup.blt.sbt

import org.scoverage.coveralls.CoverallsPlugin
import sbt._
import sbt.Keys._

object CoverallsWrapper extends AutoPlugin {
  override def requires: Plugins = CoverallsPlugin

  private def runCoveralls() = {
    val varsExist =
      sys.env.get("COVERALLS_REPO_TOKEN").exists(_.nonEmpty) ||
        sys.env.get("TRAVIS_JOB_ID").exists(_.nonEmpty)

    val prBuild =
      sys.env.get("TRAVIS_PULL_REQUEST").exists(_ != "false")

    varsExist && !prBuild
  }

  override def projectSettings: Seq[Setting[_]] = Seq(
    commands += Command.command("coverallsMaybe") { state: State =>
      if (runCoveralls()) {
        CoverallsPlugin.doCoveralls(state)
        state
      } else {
        println("No token/job id for coveralls configured, passing.")
        state
      }
    }
  )

}

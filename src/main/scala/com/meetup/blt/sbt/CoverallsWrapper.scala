package com.meetup.blt.sbt

import org.scoverage.coveralls.CoverallsPlugin
import scoverage.ScoverageKeys._
import sbt._
import sbt.Keys._

object CoverallsWrapper extends AutoPlugin {
  object autoImport {
    val coverallsPublishPrReport = settingKey[Boolean](
      "Publishes coverage reports to coveralls on pull requests."
    )
  }
  import autoImport._
  override def requires: Plugins = CoverallsPlugin

  private def runCoveralls(publishPrReport: Boolean) = {
    val varsExist =
      sys.env.get("COVERALLS_REPO_TOKEN").exists(_.nonEmpty) ||
        sys.env.get("TRAVIS_JOB_ID").exists(_.nonEmpty)

    val prBuild =
      sys.env.get("TRAVIS_PULL_REQUEST").exists(_ != "false")

    varsExist && (publishPrReport || !prBuild)
  }

  override def projectSettings: Seq[Setting[_]] = Seq(
    coverallsPublishPrReport := false,
    coverageExcludedFiles in ThisBuild := ".*target/.*",
    commands += Command.command("coverallsMaybe") { state: State =>
      if (runCoveralls(coverallsPublishPrReport.value)) {
        CoverallsPlugin.doCoveralls(state)
        state
      } else {
        println("No token/job id for coveralls configured, passing.")
        state
      }
    }
  )

}

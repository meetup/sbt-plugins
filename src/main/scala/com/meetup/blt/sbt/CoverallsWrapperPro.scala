package com.meetup.blt.sbt

import org.scoverage.coveralls.Imports.CoverallsKeys.coverallsServiceName
import sbt._

object CoverallsWrapperPro extends AutoPlugin {
  override def requires: Plugins = CoverallsWrapper

  override def projectSettings: Seq[Setting[_]] = Seq(
    coverallsServiceName := Some("travis-pro")
  )

}

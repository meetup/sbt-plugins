package com.meetup.blt.sbt

import java.io.File

import org.scalatest.{FunSpec, Matchers}

class CoverallsWrapperTest extends FunSpec with Matchers {

  val coverallsDir = new File("src/component/sbt/coveralls")

  val sbt = new Sbt(coverallsDir)

  it("should run without failing") {
    sbt("coverallsMaybe")
  }

  it("should error attempt coveralls (and fail) when token env var is present") {
    // Runtime exception of non zero exit.
    a [java.lang.RuntimeException] should be thrownBy {
      sbt.runWith(Map("COVERALLS_REPO_TOKEN" -> "fake"), "coverallsMaybe")
    }
  }

}

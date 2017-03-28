package com.meetup.blt.sbt

import java.io.File

import org.scalatest.{FunSpec, Matchers}

class CoverallsWrapperTest extends FunSpec with Matchers {

  val coverallsDir = new File("src/component/sbt/coveralls")

  val sbt = new Sbt(coverallsDir)

  it("should run without failing") {
    sbt("coverallsMaybe")
  }

  it("should attempt to run coveralls (and fail) when token env var is present") {
    // Runtime exception of non zero exit.
    a [java.lang.RuntimeException] should be thrownBy {
      sbt.runWith(Map("COVERALLS_REPO_TOKEN" -> "fake"), "coverallsMaybe")
    }
  }

  it("should attempt to run coveralls (and fail) when job id env var is present") {
    // Runtime exception of non zero exit.
    a [java.lang.RuntimeException] should be thrownBy {
      sbt.runWith(Map("TRAVIS_JOB_ID" -> "123"), "coverallsMaybe")
    }
  }

  it("should attempt to run coveralls (and fail) if not pull request build") {
    a [java.lang.RuntimeException] should be thrownBy {
      sbt.runWith(Map(
        "TRAVIS_JOB_ID" -> "123",
        "TRAVIS_PULL_REQUEST" -> "false"
      ), "coverallsMaybe")
    }
  }

  it("should not be configured to publish reports on prs by default") {
    val res = sbt.lastLine("export coverallsPublishPrReport")
    res shouldBe "false"
  }

  it("should not attempt to run if pull request build") {
    sbt.runWith(Map(
      "TRAVIS_JOB_ID" -> "123",
      "TRAVIS_PULL_REQUEST" -> "123"
    ), "coverallsMaybe")
  }

  it("should not attempt to run coveralls when token env var is empty") {
    sbt.runWith(Map("COVERALLS_REPO_TOKEN" -> ""), "coverallsMaybe")
  }

}

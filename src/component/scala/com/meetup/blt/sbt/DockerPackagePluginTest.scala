package com.meetup.blt.sbt

import java.io.File
import org.scalatest.{Matchers, FunSpec}

class DockerPackagePluginTest extends FunSpec with Matchers {

  val dockerPackageDir = new File("src/component/sbt/docker-package")

  val sbt = new Sbt(dockerPackageDir)

  it("should load image name from Makefile") {
    sbt.secondToLast("show docker:dockerTarget") should include ("mup.cr/blt/publish-test")
  }

  it("should load base tag from Makefile") {
    sbt.lastLine("export dockerBaseImage") shouldBe "java:8"
  }

  it("should run tests before publishing") {
    sbt("docker:publishLocal") should include ("Tests: succeeded 1")
  }

}

package com.meetup.blt.sbt

import java.io.File

import org.scalatest.{Matchers, FunSpec}

class CommonSettingsPluginTest extends FunSpec with Matchers {

  val commonSettingsDir = new File("src/it/sbt/common-settings")

  val sbt = new Sbt(commonSettingsDir)

  it("should set organization") {
    val res = sbt.lastLine("export organization")
    res shouldBe "com.meetup"
  }

  it("should retrieve version from Makefile") {
    val res = sbt.lastLine("export version")
    res shouldBe "0.0.1-snapshot"
  }

  it("should add a component test config") {
    sbt("component:test") should include ("Tests: succeeded 2")
  }

  it("should add an integration test config") {
    sbt("it:test") should include ("Tests: succeeded 1")
  }

  it("should set project to snapshot") {
    sbt.lastLine("export isSnapshot") shouldBe "true"
  }

}

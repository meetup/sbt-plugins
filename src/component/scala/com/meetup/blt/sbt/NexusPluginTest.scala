package com.meetup.blt.sbt

import java.io.File

import org.scalatest.{Matchers, FunSpec}

class NexusPluginTest extends FunSpec with Matchers {

  val nexusDir = new File("src/component/sbt/nexus")

  val sbt = new Sbt(nexusDir)

//  it("should publish snapshot") {
//    sbt("publish") should include ("[success]")
//  }

}

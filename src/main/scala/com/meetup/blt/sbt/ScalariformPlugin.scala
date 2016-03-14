package com.meetup.blt.sbt

import com.typesafe.sbt.SbtScalariform
import sbt._

import scalariform.formatter.preferences._


object ScalariformPlugin extends AutoPlugin {

  override def projectSettings: Seq[Setting[_]] =
    SbtScalariform.scalariformSettings ++ Seq(
      SbtScalariform.ScalariformKeys.preferences := SbtScalariform.ScalariformKeys.preferences.value
        .setPreference(AlignArguments, false)
        .setPreference(AlignParameters, false)
        .setPreference(AlignSingleLineCaseStatements, false)
        .setPreference(CompactControlReadability, false)
        .setPreference(CompactStringConcatenation, false)
        .setPreference(DoubleIndentClassDeclaration, true)
        .setPreference(FormatXml, true)
        .setPreference(IndentLocalDefs, true)
        .setPreference(IndentPackageBlocks, true)
        .setPreference(IndentSpaces, 2)
        .setPreference(IndentWithTabs, false)
        .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
        .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
        .setPreference(DanglingCloseParenthesis, Preserve)
        .setPreference(PreserveSpaceBeforeArguments, false)
        .setPreference(RewriteArrowSymbols, false)
        .setPreference(SpacesAroundMultiImports, false)
        .setPreference(SpaceBeforeColon, false)
        .setPreference(SpaceInsideBrackets, false)
        .setPreference(SpaceInsideParentheses, false)
        .setPreference(SpacesWithinPatternBinders, true))

}
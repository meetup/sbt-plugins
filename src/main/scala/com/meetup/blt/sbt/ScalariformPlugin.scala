package com.meetup.blt.sbt

import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.autoImport._
import scalariform.formatter.preferences._
import sbt._
import sbt.Keys._


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
        .setPreference(SpacesWithinPatternBinders, true),
      // Scalariform likes to format generated sources sometimes....
      // bad scalariform, bad.
      excludeFilter in scalariformFormat <<= excludeFilter(_ || {
        new SimpleFileFilter(_.getCanonicalPath.contains("/target/"))
      }))

}
resolvers +=  Resolver.url(
  "meetup-sbt-plugins",
  new java.net.URL("https://dl.bintray.com/meetup/sbt-plugins/")
)(Resolver.ivyStylePatterns)

addSbtPlugin("com.eed3si9n" % "sbt-dirty-money" % "0.1.0")

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

# Meetup SBT Plugins [![Build Status](https://travis-ci.org/meetup/sbt-plugins.svg?branch=master)](https://travis-ci.org/meetup/sbt-plugins)

A base collection of SBT settings that many projects should be able to take advantage of.

This includes settings like:

* Common settings
 * Organization
 * Getting version from make (our CI interface).
 * Scalariform settings
* Docker native packager settings
* Nexus publishing settings

To use you just add the plugin like any other.

## Usage

Add the sbt plugin and a resolver for our internal nexus to your `project/plugins.sbt` file.  You can find the latest version in the releases: [https://github.com/meetup/sbt-plugins/releases](https://github.com/meetup/sbt-plugins/releases)

```scala
resolvers += "Nexus" at "https://nexus.blt.meetup.com/content/repositories/releases"

addSbtPlugin("com.meetup" % "sbt-plugins" % "{latest-version}")
```

Then you can just add the settings you'd like in your `build.sbt`.

```scala
enablePlugins(CommonSettingsPlugin)
```

```scala
enablePlugins(DockerPackagePlugin)
```

```scala
enablePlugins(NexusPlugin)
```

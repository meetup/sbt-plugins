# Meetup SBT Plugins

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

Add the sbt plugin first in your `project/plugins.sbt`.

```scala
addSbtPlugin("com.meetup" % "sbt-plugins" % "jose-snapshot")
```

Then you can just add the settings you'd like in your `build.sbt`.

```scala
enablePlugins(CommonSettingsPlugin)
```

```scala
enablePlugins(ScalariformPlugin)
```

```scala
enablePlugins(DockerPlugin)
```

```scala
enablePlugins(NexusPlugin)
```

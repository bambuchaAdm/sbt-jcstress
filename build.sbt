import bintray.Keys._

sbtPlugin := true

organization := "pl.project13.sbt"
name := "sbt-jcstress"

scalaVersion := "2.10.6"
scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-target:jvm-1.6",
  "-encoding", "UTF-8"
)

libraryDependencies += Dependencies.jcstress

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots) else Some(Classpaths.sbtPluginReleases)
}

// publishing settings

publishMavenStyle := false
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
bintrayPublishSettings
repository in bintray := "sbt-plugins"
bintrayOrganization in bintray := None

scriptedSettings
scriptedLaunchOpts += s"-Dproject.version=${version.value}"

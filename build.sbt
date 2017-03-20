scalaVersion := "2.11.8"

name := "jseval"

organization := "ch.usi.jseval"

version := "1.0"

sbtRatsSettings

ratsScalaRepetitionType := Some (ListType)

ratsUseScalaOptions := true

ratsUseScalaPositions := true

ratsUseKiama := 2

ratsDefineASTClasses := true

ratsDefinePrettyPrinter := true

ratsUseDefaultSpacing := true

ratsUseDefaultLayout := true

ratsUseDefaultComments := true

ratsUseDefaultWords := true

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
// Use kiama
libraryDependencies += "org.bitbucket.inkytonik.kiama" %% "kiama" % "2.0.0"
// Logger
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"

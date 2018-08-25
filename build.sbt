name := """nairobi-jvm-sms-module"""
organization := "co.tala.nairobijvm"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "co.tala.nairobijvm.nairobijvmsmsmodule.controllers._"

// Adds additional packages into resources/routes
// play.sbt.routes.RoutesKeys.routesImport += "co.tala.nairobijvm.nairobijvmsmsmodule.binders._"

// disable default Play layout to enable SBT layout
disablePlugins(PlayLayoutPlugin)
PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value

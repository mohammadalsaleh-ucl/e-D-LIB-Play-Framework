
name := """e-D&LIB"""
organization := "com.uclouvain"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean ,PlayEnhancer)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(guice, evolutions, javaJdbc)

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.196"

libraryDependencies += "org.webjars" % "bootstrap" % "4.6.0"

libraryDependencies += javaForms

libraryDependencies += guice
name := "elasticsearch"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.7"
libraryDependencies ++= {
  val elastic4sVersion = "7.16.0"
  Seq(
    "com.sksamuel.elastic4s" %% "elastic4s-core" % elastic4sVersion,
    "com.sksamuel.elastic4s" %% "elastic4s-http" % "6.7.8",
    "com.typesafe" % "config" % "1.4.1",
    "ch.qos.logback" % "logback-classic" % "1.2.9",
    "com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.10" % Test
  )
}
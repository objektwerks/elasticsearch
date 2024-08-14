name := "elasticsearch"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.5.0-RC7"
libraryDependencies ++= {
  val elastic4sVersion = "8.11.5"
  Seq(
    "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % elastic4sVersion,
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.6",
    "com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

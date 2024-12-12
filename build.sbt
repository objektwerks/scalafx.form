name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.6.2"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "23.0.1-R34",
    "ch.qos.logback" % "logback-classic" % "1.5.12"
  )
}
scalacOptions ++= Seq(
  "-Wall"
)

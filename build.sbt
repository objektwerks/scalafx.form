name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.6.3-RC2"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "23.0.1-R34",
    "ch.qos.logback" % "logback-classic" % "1.5.15"
  )
}
scalacOptions ++= Seq(
  "-Wall"
)

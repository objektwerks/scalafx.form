name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.4.2-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "22.0.0-R33",
    "ch.qos.logback" % "logback-classic" % "1.5.5"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

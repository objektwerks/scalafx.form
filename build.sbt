name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.5.2-RC2"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "22.0.0-R33",
    "ch.qos.logback" % "logback-classic" % "1.5.8"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

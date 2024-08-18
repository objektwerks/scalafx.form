name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.5.0"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "22.0.0-R33",
    "ch.qos.logback" % "logback-classic" % "1.5.7"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

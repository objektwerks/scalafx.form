name := "scalafx.form"
organization := "objektwerks"
version := "0.5-SNAPSHOT"
scalaVersion := "3.4.0-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "21.0.0-R32",
    "ch.qos.logback" % "logback-classic" % "1.4.14"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
name := "scalafx.form"
organization := "objektwerks"
version := "0.21-SNAPSHOT"
scalaVersion := "3.4.1-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "21.0.0-R32",
    "ch.qos.logback" % "logback-classic" % "1.5.3"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)

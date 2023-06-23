ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

// https://mvnrepository.com/artifact/org.scalafx/scalafx
libraryDependencies += "org.scalafx" %% "scalafx" % "20.0.0-R31"


lazy val root = (project in file("."))
  .settings(
    name := "snake-scala",
    idePackagePrefix := Some("com.akgroup.snake")
  )

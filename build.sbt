name := "sparkSamples"

val sparkVersion = "2.2.0"

val commonSettings = Seq(
  version := "1.0",
  organization := "com.github.uryyyyyyy",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )
)

lazy val batch_helloWorld = (project in file("batch_helloWorld"))
  .settings(commonSettings: _*)
  .settings(
    name := "batch_helloWorld"
  )

lazy val batch_multi_thread_pool = (project in file("batch_multi_thread_pool"))
  .settings(commonSettings: _*)
  .settings(
    name := "batch_multi_thread_pool"
  )

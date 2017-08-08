name := "sparkSamples"

version := "1.0"

val sparkVersion = "2.1.1"

lazy val batch_helloWorld = (project in file("batch_helloWorld"))
  .settings(
    scalaVersion := "2.12.3",
    name := "spark_batch_helloworld",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
    )
  )


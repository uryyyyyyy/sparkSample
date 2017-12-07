package com.github.uryyyyyyy.spark.batch.helloworld

import org.apache.spark.{SparkConf, SparkContext}

object Hello8 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("s3://opt-uryyyyyyy/spark/data/hello", 10)
    println("----Start----")

    rdd.map(str => str.toInt).map(i => (i%20, i))
      .reduceByKey((acc, i) => acc + 1)
      .foreach{case (key, value) =>
        if (key == 10) throw new RuntimeException
        println(s"key: ${key}, value:${value}")
      }
  }
}
package com.github.uryyyyyyy.spark.batch.helloworld

import org.apache.spark.{SparkConf, SparkContext}

object Hello9 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("s3://opt-uryyyyyyy/spark/data/hello", 10)
    println("----Start----")

    rdd.map(str => str.toInt).map(i => (i%20, i))
      .reduceByKey((acc, i) => acc + 1)
      .collect
      .foreach{case (key, value) => println(s"key: ${key}, value:${value}")}
  }
}
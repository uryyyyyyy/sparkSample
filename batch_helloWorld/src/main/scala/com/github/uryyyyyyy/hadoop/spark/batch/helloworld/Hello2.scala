package com.github.uryyyyyyy.hadoop.spark.batch.helloworld

import org.apache.spark.{SparkConf, SparkContext}

object Hello2 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val rdd = sc.range(1, 100000, 1, 10)
    println("----Start----")

    rdd.saveAsTextFile("s3://opt-uryyyyyyy/spark/data/hello")
  }
}
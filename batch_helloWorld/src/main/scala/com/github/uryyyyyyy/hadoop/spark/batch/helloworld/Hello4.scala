package com.github.uryyyyyyy.hadoop.spark.batch.helloworld

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Hello4 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("s3://opt-uryyyyyyy/spark/data/hello", 10)
    println("----Start----")

    rdd.persist(StorageLevel.MEMORY_ONLY)

    //1st
    rdd.map(i => i.toInt * 2)
      .foreach(i => println(i))

    //2nd
    rdd.map(i => i.toInt * 3)
      .foreach(i => println(i))
  }
}
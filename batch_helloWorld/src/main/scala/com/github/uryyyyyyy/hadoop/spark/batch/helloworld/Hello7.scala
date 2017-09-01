package com.github.uryyyyyyy.hadoop.spark.batch.helloworld

import org.apache.spark.{SparkConf, SparkContext}

object Hello7 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("s3://opt-uryyyyyyy/spark/data/hello", 10)
    println("----Start----")

    rdd.map(str => str.toInt).map(i => (i%20, i))
      //      .groupByKey(20).map{case (key, itr) => (key, itr.size)}
      .reduceByKey((acc, i) => acc + 1)
//      .mapPartitions(itr => itr.toSeq.groupBy( _._1 ).mapValues(_.length).toIterator)
//      .groupByKey().map{case (key, itr) => (key, itr.sum)}
      .foreach{case (key, value) => println(s"key: ${key}, value:${value}")}

  }
}
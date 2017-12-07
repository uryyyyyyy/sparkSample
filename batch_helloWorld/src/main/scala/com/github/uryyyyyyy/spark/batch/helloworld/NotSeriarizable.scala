package com.github.uryyyyyyy.spark.batch.helloworld

import org.apache.spark.{SparkConf, SparkContext}

object NotSeriarizable {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val seq = Seq(new NotSeriarizableObj(1, "Alice"), new NotSeriarizableObj(2, "Bob"))
    val rdd = sc.parallelize(seq)
    println("----Start----")

    rdd.map(i => i.getName())
      .foreach(i => println(i))
  }
}

class NotSeriarizableObj(id: Long, name: String) {
  def getName(): String ={
    this.toString
  }
}
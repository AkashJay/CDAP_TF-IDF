import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import scala.io.Source

/**
  * Created by akash on 2/13/19.
  */
object Test {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark =  SparkSession.builder().master("local").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits._


    val linesRDD: RDD[String] = sc.textFile("in/2.txt")

    val splitText: RDD[List[String]] = linesRDD.map(x => x.split("\\s+").map(_.trim).toList)

    val a = splitText.toDF


    for (q <- splitText){
      println(q)
    }
    a.show()
  }

}

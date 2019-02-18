import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._


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


    val linesRDD: RDD[String] = sc.textFile("in/Test")
    val splitText: RDD[List[String]] = linesRDD.map(x => x.split("\\s+").map(_.trim).toList)
    val documents: DataFrame = splitText.toDF

    val dfWithDocId = documents.withColumn("doc_id", monotonically_increasing_id()).withColumnRenamed("value", "document")

    val columns = dfWithDocId.columns.map(col) :+
      (explode(col("document")) as "token")

    val unfoldedDocs = dfWithDocId.select(columns: _*)


    val tremFrequency = unfoldedDocs.groupBy("doc_id", "token")
      .agg(count("document") as "tf")

    val documentFrequency = tremFrequency.groupBy("token")
        .agg(countDistinct("doc_id") as "df")

    documentFrequency.show()



    val calcIdfUdf = udf { df: Long =>
                math.log(4/df.toDouble +1)
    }

    val IDF: DataFrame = documentFrequency.withColumn("idf", calcIdfUdf(col("df")))


    val TF_IDF = tremFrequency.join(IDF, Seq("token"), "left")
                               .withColumn("tf_idf", col("tf") * col("idf"))

    TF_IDF.show()




  }



}

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame, SparkSession}

/**
  * Created by akash on 2/25/19.
  */
object TfIdfCalculator {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark =  SparkSession.builder().master("local").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits._

    //Read data from text files to Line RDD
    val linesRDD: RDD[String] = sc.textFile("in/Test")

    // Split each text by space and create a list of words
    val splitText: RDD[List[String]] = splitTextBySpace(linesRDD)

    //create a dataframe from splitted documents
    val documents: DataFrame = splitText.toDF
    //Count tottal number of documents in the cropus
    val docCount: Double = documents.count()

    //Add a unique ID to each document and change the name of value column to document
    val dfWithDocId = documents.withColumn("doc_id", monotonically_increasing_id()).withColumnRenamed("value", "document")
    //dfWithDocId.show()

    val columns: Array[Column] = dfWithDocId.columns.map(col) :+
      (explode(col("document")) as "token")
    //for (word <- columns) println(word)


    //seperate tokens from documents
    val unfoldedDocs: DataFrame = dfWithDocId.select(columns: _*)
    //unfoldedDocs.show()

    //calculate the term frequency by grouping data usin doi id and token

//    val calcTF = udf { df: Long =>
//      1 + math.log10(df)
//    }
    val tremFrequency: DataFrame = unfoldedDocs.groupBy("doc_id", "token")
        .agg(count("document") as "tf")
    //tremFrequency.show()

    //Calculate dofcument frequency
    val documentFrequency = tremFrequency.groupBy("token")
                                  .agg(countDistinct("doc_id") as "df")
    //documentFrequency.show()

    val calcIdfUdf = udf { df: Long => math.log((docCount.toDouble + 1) / (df.toDouble + 1)) }
    //calculate IDF for each distinct token
    val IDF: DataFrame = documentFrequency.withColumn("idf", calcIdfUdf(col("df")))
    IDF.show()

    val TF_IDF = tremFrequency.join(IDF, Seq("token"), "left")
      .withColumn("tf_idf", col("tf") * col("idf"))
    TF_IDF.orderBy(col("tf_idf").desc).show()




  }

  def splitTextBySpace (linesRDD: RDD[String]): RDD[List[String]] = {
    linesRDD.map(x => x.split("\\s+").map(_.trim).toList)
  }

}

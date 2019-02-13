import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

/**
  * Created by akash on 2/13/19.
  */
object Test {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession.builder().appName("DataframeExample").master("local[1]").getOrCreate()

    val dataFrameReader = session.read


    val responses = dataFrameReader
      .option("header", "false")
      .option("inferSchema", value = false)
      .csv("in/clickstream.csv")

    val responseWithSelectedColumns = responses.select(responses("_c0"), responses("_c1"), responses("_c2"), responses("_c3"))

    val groupedData = responseWithSelectedColumns.groupBy(responses("_c0"))
    val groupDataWithCount = groupedData.count()
    groupDataWithCount.orderBy(groupDataWithCount.col("count").desc).show(5)

    session.stop()
  }
}

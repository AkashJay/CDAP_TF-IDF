package MachineLearning
import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession
object Classification {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark =  SparkSession.builder().master("local").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits._

    // Load the data stored in LIBSVM format as a DataFrame.
//    val data = spark.read.format("libsvm").load("/home/akash/Documents/aa.txt").toDF("")
//    df = spark.read.format("csv").option("header", "true").load("csvfile.csv")
    val data = spark.read.format("csv").option("delimiter", ",").load("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/Document Classification Model/SInhalaAll.csv").toDF("label", "feature")
//    data.show()


    //    // Split the data into training and test sets (30% held out for testing)
//    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)
//
//    // Train a NaiveBayes model.
//    val model = new NaiveBayes()
//      .fit(trainingData)
//
//    // Select example rows to display.
//    val predictions = model.transform(testData)
//    predictions.show()
//
//    // Select (prediction, true label) and compute test error
//    val evaluator = new MulticlassClassificationEvaluator()
//      .setLabelCol("label")
//      .setPredictionCol("prediction")
//      .setMetricName("accuracy")
//    val accuracy = evaluator.evaluate(predictions)
//    println("Test set accuracy = " + accuracy)
  }
}

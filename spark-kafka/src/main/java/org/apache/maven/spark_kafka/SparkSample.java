package org.apache.maven.spark_kafka;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
 
public class SparkSample {
 
	public static void main(String[] args) {
 
		SparkConf sparkConf = new SparkConf();
 
		sparkConf.setAppName("Hello Spark");
		sparkConf.setMaster("local");
 
		JavaSparkContext context = new JavaSparkContext(sparkConf);
 
		//...
 
		context.close();
 
	}
 
}
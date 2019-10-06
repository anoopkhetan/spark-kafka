package org.apache.maven.spark_kafka;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> inputData = new ArrayList<>();
		inputData.add(10.5);
		inputData.add(10.1);
		inputData.add(12.5);
		inputData.add(20.3);
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkConf conf = new SparkConf().setAppName("javaSpark").setMaster("local[*]");
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<Double> myRdd = sc.parallelize(inputData);
		sc.close();

	}

}

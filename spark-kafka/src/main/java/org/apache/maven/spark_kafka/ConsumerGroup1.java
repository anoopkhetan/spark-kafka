package org.apache.maven.spark_kafka;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

public class ConsumerGroup1 {
   public static void main(String[] args) throws Exception {
		/*
		 * if(args.length < 2){
		 * System.out.println("Usage: consumer <topic> <groupname>"); return; }
		 */
	   
      
      Logger logger = LoggerFactory.getLogger(ConsumerGroup1.class.getName());
 
      //String topic = args[0].toString();
      //String group = args[1].toString();
      String bootstrapServer = "localhost:9092";
      String groupId = "my-first-application";
      String topic = "myfirst-topic";
 
      Properties props = new Properties();
      props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
      //props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
      //props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
      
      props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
      props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest"); //latest,earliest
      
      
      //props.put("enable.auto.commit", "true");
      //props.put("auto.commit.interval.ms", "1000");
      //props.put("session.timeout.ms", "30000");
      
 
      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
 
 
      consumer.subscribe(Arrays.asList(topic));
      System.out.println("Subscribed to topic " + topic);
      int i = 0;
 
      while (true) {
    	  //ConsumerRecords<String, String> records = consumer.poll(100);  Depricatred use below for latest
    	  ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for 
            (ConsumerRecord<String, String> record : records)
               {System.out.printf("offset = %d, key = %s, value = %s, partition = %d\n",
               record.offset(), record.key(), record.value(), record.partition());
               //logger.info("offset :" + record.offset()); 
               }
        }
   } 
}
package org.apache.maven.spark_kafka;
import java.util.Properties;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
 
//Create java class named “SimpleProducer”
public class SimpleProducer1 {
 
   public static void main(String[] args) throws Exception{
 
      // Check arguments length value
		/*
		 * if(args.length == 0){ System.out.println("Enter topic name"); return; }
		 */
 
      String topicName = "myfirst-topic";
      String bootstrapServer = "localhost:9092";
      String groupId = "my-first-application";
 
      Properties props = new Properties();
      props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
      //props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,SimpleProducer1.class.getName());
      //props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,SimpleProducer1.class.getName());
      props.setProperty(ProducerConfig.ACKS_CONFIG,"all");
      //props.setProperty(ProducerConfig.RETRIES_CONFIG,0);
      //props.put("batch.size", 16384);
      //Reduce the no of requests less than 0  
      //props.put("linger.ms", 1);
      //The buffer.memory controls the total amount of memory available to the producer for buffering.  
      //props.put("buffer.memory", 33554432);
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
 
      Producer<String, String> producer = new KafkaProducer
         <String, String>(props);
 
      for(int i = 400; i < 410; i++) {
    	  String key = Integer.toString(i) + "_key";
    	  String value = "value_" + Integer.toString(i);
          producer.send(new ProducerRecord<String, String>(topicName,key, value));
          System.out.println("key :" + key + "value :" + value);
          }
      
      System.out.println("Message(s) sent successfully");
      producer.close();
   }
}
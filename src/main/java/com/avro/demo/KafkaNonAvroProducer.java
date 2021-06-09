package com.avro.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import com.example.Customer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class KafkaNonAvroProducer {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers","localhost:9092");
		properties.setProperty("acks","0");
		properties.setProperty("retries","0");
		
		properties.setProperty("batch-size","100000");
		properties.setProperty("request.timeout.ms","30000");
		properties.setProperty("linger.ms","10");
		properties.setProperty("buffer-memory","33554432");
		properties.setProperty("max.block.ms","5000");
		
		
		
		properties.setProperty("key.serializer",StringSerializer.class.getName());
		properties.setProperty("value.serializer",JsonSerializer.class.getName());
		properties.setProperty("schema.registry.url","http://localhost:8081");
		
		
		KafkaProducer<String,Object> kafkaProducer = new KafkaProducer<String,Object>(properties);		
		String topic = "test-topic";
		
		Customer customer = Customer.newBuilder()
				.setFirstName("Soum")
				.setLastName("Sengupta")
				.setAge(41)
				.setHeight(5.11f)
				.setWeight(180)
				.build();
		
		JsonObject jsonCustomer = new JsonParser().parse(customer.toString()).getAsJsonObject();
		
		ProducerRecord<String,Object> producerRecord = new ProducerRecord<String,Object>(topic,jsonCustomer);
		
		kafkaProducer.send(producerRecord, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if (exception == null) {
					System.out.println("Success  is "+metadata.toString());
					
				} else {
					System.out.println("Error Caught is ");
					exception.printStackTrace();
				}
				
			}});
		kafkaProducer.flush();
		kafkaProducer.close();
	}

}

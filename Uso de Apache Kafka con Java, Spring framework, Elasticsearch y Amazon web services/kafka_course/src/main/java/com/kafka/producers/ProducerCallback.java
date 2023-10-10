package com.kafka.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerCallback {
	public static final Logger log = LoggerFactory.getLogger(ProducerCallback.class);
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092");// Broker de kafka al que nos vamos a conectar
		props.put("acks","all");// se puede poner 1 o 2 referente al broker
		props.put("key.serializer",	"org.apache.kafka.common.serialization.StringSerializer");// en este caso es para que sea un string
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("linger.ms","1");

		// el callback permite que se ejecute una vez terminada un proceso se ejecute lo que contiene dentrro
		try(Producer<String, String> producer = new	KafkaProducer<>(props)) {
			for(int i= 0;i< 10000;i++) {
				producer.send(new ProducerRecord<>("devs4j-topic",String.valueOf(i), "devs4j-value"),
						new Callback() {
							
							@Override
							public void onCompletion(RecordMetadata metadata, Exception exception) {
								if(exception != null) {
									log.info("there was an error {}", exception.getMessage());
								}
								log.info("Offset = {}, Partition = {}, Topic = {}", metadata.offset(),
										metadata.partition(), metadata.topic());
							}
						});
			}
			producer.flush();
		}
		
		log.info("processing time = {} ms ", (System.currentTimeMillis()-startTime));
		
	}
}

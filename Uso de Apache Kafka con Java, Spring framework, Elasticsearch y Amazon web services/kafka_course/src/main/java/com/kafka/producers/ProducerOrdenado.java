package com.kafka.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerOrdenado {
public static final Logger log = LoggerFactory.getLogger(ProducerOrdenado.class);
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092");// Broker de kafka al que nos vamos a conectar
		props.put("acks","all");// se puede poner 1 o 2 referente al broker
		props.put("linger.ms","1");
		props.put("key.serializer",	"org.apache.kafka.common.serialization.StringSerializer");// en este caso es para que sea un string
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		//este nos puede ayudar a preservar el orden de los mensajes en la particion 
		try(Producer<String, String> producer = new	KafkaProducer<>(props)) {
			for(int i= 0;i< 10000;i++) {
				//producer.send(new ProducerRecord<String, String>(
				producer.send(new ProducerRecord<>(
						"devs4j-topic",
						(i%2==0)? "key-2" : "key-3",
						String.valueOf(i)));
			}
			producer.flush();
		}
		
		log.info("processing time = {} ms ", (System.currentTimeMillis()-startTime));
		
	}
}

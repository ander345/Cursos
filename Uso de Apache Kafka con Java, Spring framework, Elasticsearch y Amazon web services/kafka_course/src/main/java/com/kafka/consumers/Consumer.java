package com.kafka.consumers;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Consumer {

	public static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("group.id","devs4j-group");
		props.setProperty("enable.auto.commit","true");
		props.setProperty("auto.commit.interval.ms","1000");
		props.setProperty("key.deserializer",
		"org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer",
		"org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("isolation.level","read_committed");
		// se puede poner asi, o directamenter el valor como los demas, esta forma es mejor practica
		//este es para deshabilitar los commit 
		//props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false") 
		
		try(KafkaConsumer<String, String>consumer=new KafkaConsumer<>(props);) {
			consumer.subscribe(Arrays.asList("devs4j-topic"));
			while(true) {
				ConsumerRecords<String,String>records=
				consumer.poll(Duration.ofMillis(100));
				for(ConsumerRecord<String,String>record:records)
					log.info("partition = {} , offset = {}, key = {},value = {}",
						record.partition(),record.offset(),record.key(),record.value());
				//se debe agregar esta propiedad para deshabilitar commits
				//consumer.commitSync();
			}
		}
	}

}

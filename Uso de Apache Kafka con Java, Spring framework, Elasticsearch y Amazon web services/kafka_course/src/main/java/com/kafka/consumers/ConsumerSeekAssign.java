package com.kafka.consumers;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerSeekAssign {
	public static final Logger log = LoggerFactory.getLogger(ConsumerSeekAssign.class);
	
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
		
		try(KafkaConsumer<String, String>consumer=new KafkaConsumer<>(props);) {
			TopicPartition topicPartition = new TopicPartition("devs4j-topic", 4);
			consumer.assign(Arrays.asList(topicPartition));
			consumer.seek(topicPartition, 50);
			while(true) {
				ConsumerRecords<String,String>records=
				consumer.poll(Duration.ofMillis(100));
				for(ConsumerRecord<String,String>record:records)
					log.info("partition = {} , offset = {}, key = {},value = {}",
						record.partition(),record.offset(),record.key(),record.value());
			}
		}
	}
}

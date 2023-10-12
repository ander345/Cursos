package com.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.kafka.models.TransactionModel;

@SpringBootApplication
public class KafkaCursoSpringExampleApplication {

	public static final Logger log = LoggerFactory.getLogger(KafkaCursoSpringExampleApplication.class);
	

	@Autowired
	public ObjectMapper mapper;

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(id ="autoStartup", autoStartup ="true",topics ="topic-transaction",containerFactory
			="kafkaListenerContainerFactory", groupId ="consumerGroup",
			properties ={"max.poll.interval.ms:60000","max.poll.records:100"})
	public void listen(List<ConsumerRecord<String, String>> messages) throws JsonMappingException, JsonProcessingException {// este throw lo propaga
		for(ConsumerRecord<String, String> message:messages) {
			//lo comentario mietras tanto para saber donde almacenarlo
			//TransactionModel transactionModel = mapper.readValue(message.value(), TransactionModel.class);
			log.info("Partition = {} , Offset = {} ,key = {} ,  Messasge = {}: ",
								message.partition(), message.offset(), message.key(), message.value());
		}
		log.info("Batch complete");
		
	}
	
	@Scheduled(fixedRate = 10000)
	public void SendMessage() throws JsonProcessingException {
		// me genera mensajes automaticos para pruebas
		Faker faker = new Faker();
		for(int i=0; i <= 10000;i++) {
			TransactionModel transationModel = new TransactionModel();
			transationModel.setUsername(faker.name().username());
			transationModel.setNombre(faker.name().firstName());
			transationModel.setApellido(faker.name().lastName());
			transationModel.setMonto(faker.number().randomDouble(4, 0,20000000 ));
			kafkaTemplate.send("topic-transaction",transationModel.getUsername(),
					mapper.writeValueAsString(transationModel));
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(KafkaCursoSpringExampleApplication.class, args);
	}

}

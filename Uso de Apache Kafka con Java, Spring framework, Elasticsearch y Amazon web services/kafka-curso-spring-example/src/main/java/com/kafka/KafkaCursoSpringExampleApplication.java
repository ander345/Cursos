package com.kafka;

import java.lang.StackWalker.Option;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
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
	private RestHighLevelClient client;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(id ="autoStartup", autoStartup ="true",topics ="topic-transaction",containerFactory
			="kafkaListenerContainerFactory", groupId ="consumerGroup",
			properties ={"max.poll.interval.ms:60000","max.poll.records:100"})
	public void listen(List<ConsumerRecord<String, String>> messages) throws JsonMappingException, JsonProcessingException {// este throw lo propaga
		for(ConsumerRecord<String, String> message:messages) {
			//lo comentario mietras tanto para saber donde almacenarlo
			//TransactionModel transactionModel = mapper.readValue(message.value(), TransactionModel.class);
			//log.info("Partition = {} , Offset = {} ,key = {} ,  Messasge = {}: ",
				//				message.partition(), message.offset(), message.key(), message.value());
			IndexRequest indexRequest = buildIndexRequest(String.format("%s-%s-%s",message.partition(), message.offset(), message.key())
					,message.value());
			
			client.indexAsync(indexRequest,  RequestOptions.DEFAULT,new ActionListener<IndexResponse>() {
				@Override
				public void onResponse(IndexResponse response) {
					log.debug("Successful");
				}
				
				@Override
				public void onFailure(Exception e) {
				log.error("Error Store");
				}
				
				
				
			});
		}
		log.info("Batch complete");
		
	}
	private IndexRequest buildIndexRequest(String key, String value) {
		IndexRequest request= new
				IndexRequest("test-transactions");
		
		request.id(key);
		request.source(value,XContentType.JSON);
		return request;
		
	}
	
	@Scheduled(fixedRate = 10000)
	public void SendMessage() throws JsonProcessingException {
		// me genera mensajes automaticos para pruebas
		Faker faker = new Faker();
		for(int i=0; i <= 10;i++) {
			TransactionModel transationModel = new TransactionModel();
			transationModel.setUsername(faker.name().username());
			transationModel.setNombre(faker.name().firstName());
			transationModel.setApellido(faker.name().lastName());
			transationModel.setMonto(faker.number().randomDouble(4, 0,20000 ));
			kafkaTemplate.send("topic-transaction",transationModel.getUsername(),
					mapper.writeValueAsString(transationModel));
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(KafkaCursoSpringExampleApplication.class, args);
	}

}

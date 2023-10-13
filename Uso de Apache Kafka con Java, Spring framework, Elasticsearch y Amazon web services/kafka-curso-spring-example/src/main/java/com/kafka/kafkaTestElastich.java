package com.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
public class kafkaTestElastich {//implements CommandLineRunner {

	/**
	 * se comentaria para que no interfiera, unicamente prueba de elastich rapida
	 */
	/*public static final Logger log = LoggerFactory.getLogger(KafkaCursoSpringExampleApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(KafkaCursoSpringExampleApplication.class, args);
	}
	
	@Autowired
	private RestHighLevelClient client;
	
	@Override
	public void run(String... args) throws Exception {
	
		IndexRequest request= new
				IndexRequest("test-transactions");
		
		request.id("3");
		request.source("{\"nombre\":\"Sammie\","
		+"\"apellido\":\"Goldner\","
		+"\"username\":\"hugh.vonrueden\","
		+"\"monto\":9622235.2009}", XContentType.JSON);
		
		IndexResponse response= client.index(request, RequestOptions.DEFAULT);
		
		log.info("Response id = {} ", response.getId());
	}
	*/
}
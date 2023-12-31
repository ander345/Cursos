package com.kafka;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class KafkaCursoSpringApplication { //implements CommandLineRunner{ // se agrrega para pruebas void run
	
	public static final Logger log = LoggerFactory.getLogger(KafkaCursoSpringApplication.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	//este recibe mensajes de kafka 
	/*@KafkaListener(topics ="devs4j-topic", groupId ="consumer")
	public void listen(String message) {
		System.out.println("Received Messasge in group foo:	"+message);
	}*/
	
	//para recibir multiples mensajes
	@KafkaListener(id ="autoStartup", autoStartup ="true",topics ="devs4j-topic",containerFactory
			="kafkaListenerContainerFactory", groupId ="consumer",
			properties ={"max.poll.interval.ms:60000","max.poll.records:100"})
	public void listen(List<String> messages) {
		for(String message:messages) {
			System.out.println("Received Messasge in group foo:	"+message);
		}
		log.info("Batch complete");
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(KafkaCursoSpringApplication.class, args);
	}
	
	//-------------- ejemplo 1 -------------
	//este me sirve para agregar un mensaje al iniciar 
	/*@Autowired
	public void run(String...  args) throws Exception {
			kafkaTemplate.send("devs4j-topic", "sample message");
	}*/
	
	//----------- ejemplo 2 con callback asincrona---------------- error en java 17, test en java 11
	/*@Autowired
	public void run(String...  args) throws Exception {
		ListenableFuture<SendResult<String, String>>future=	kafkaTemplate.send("devs4j-topic","Sample message ");
				future.addCallback(new KafkaSendCallback<String, String>() {
					
				@Override
				public void onSuccess(SendResult<String, String>result) {
					log.info("Message sent");
				}
				@Override
				public void onFailure(Throwable ex) {
					log.error("Error sending message ",ex);
				}
				@Override
				public void onFailure(KafkaProducerException ex) {
					log.error("Error sending message ",ex);
				}
				});
	}*/
	
	//solucion segun chatgps
	/*@Autowired
	public void run(String... args) throws Exception {
	    CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("devs4j-topic", "Sample message ");
	    future.whenComplete((result, ex) -> {
	        if (ex != null) {
	            log.error("Error sending message", ex);
	        } else {
	            log.info("Message sent");
	        }
	    });
	    // Puedes manejar excepciones aquí si es necesario.
	    try {
	        SendResult<String, String> result = future.get();
	    } catch (InterruptedException | ExecutionException e) {
	        log.error("Error sending message", e);
	    }
	}*/
	
	
	//--------------- ejemplo 3------------ callback de forma sincrona
	/*@Autowired
	public void run(String...  args) throws Exception {
			kafkaTemplate.send("devs4j-topic", "sample message").get();//se puede poner dentro del get(100,TimeUnit.MILLISECONDS)
			//si no se entrega el mensaje despes de ese tiempo se genera una exception.
	}*/
	
	//------ ejemplo 4 para envio de artos mensajes y pausar consumo --------
	/*@Autowired
	private KafkaListenerEndpointRegistry registry;
	
	
	public void run(String...  args) throws Exception {
		for(int i=0;i<100;i++) {
			kafkaTemplate.send("devs4j-topic", String.format("sample message %d", i));
			log.info("Waiting");
			Thread.sleep(5000);
			log.info("Start");
			registry.getListenerContainer("autoStartup").start();
			Thread.sleep(5000);
			registry.getListenerContainer("autoStartup").stop();
		}
		
		
	}*/
	
	//-------- ejemplo 5 metricas, probando primero @enablecheduler----------
	/*@Scheduled(fixedDelay = 2000, initialDelay = 100) // est permite que este metodo se ejecute cada cierto tiempo
	public void print() {
		log.info("prueba");
	}*/
	
	
	//------- metricas
	@Autowired
	private MeterRegistry meterRegistry;
	
	@Scheduled(fixedDelay = 2000, initialDelay = 100)
	public void schedule() {
		log.info("Sending messages ");
		for(int i= 0;i< 200;i++) {
			kafkaTemplate.send("devs4j-topic","Message"+i);
		}
	}
	
	//imprime la metrica
	@Scheduled(fixedDelay = 2000, initialDelay = 500)
	public void messageCountMetric() {
		double count =	meterRegistry.get("kafka.producer.record.send.total")
		.functionCounter().count();
		log.info("Count {} ",count);
		/*for(Meter meter:meters) {
			log.info("Metric {} ",meter.getId());
		}*/
	}
	
	
}

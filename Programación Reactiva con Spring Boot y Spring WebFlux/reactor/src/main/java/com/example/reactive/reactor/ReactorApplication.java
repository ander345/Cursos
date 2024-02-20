package com.example.reactive.reactor;

import javax.lang.model.element.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.reactive.reactor.models.Usuario;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactorApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ReactorApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Flux<String> nombres = Flux.just("Andres pepe","Carlos fulano","maria paco","Juan sultano","Marco henao","Marco polo");
				//.doOnNext(element -> System.out.println(element)); 
				//.doOnNext(System.out::println);//igual que la linea anterior pero mas simple, coo una referecia de metodo
			Flux<Usuario> usuarios = nombres.map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(),nombre.split(" ")[1].toUpperCase()))
				.filter(usuario-> usuario.getNombre().toLowerCase().equals("marco"))
				.doOnNext(usuario ->{
					if(usuario== null) {
						throw new RuntimeException("nombre no puede ser vacio");
					}
					System.out.println(usuario.getNombre().concat(" ").concat(usuario.getApellido()));				
				})
				.map(usuario -> {
					String nombre = usuario.getNombre().toLowerCase();
					usuario.setNombre(nombre);
					return usuario;
				})
				; 
		
		//nombres.subscribe(log::info);
		usuarios.subscribe(e -> log.info(e.toString()),
				error->log.error(error.getMessage()),
				new Runnable() {// este se ejecuta solo si no hay errores
					@Override
					public void run() {
						log.info("Ha finalizado con exito el observable");
					}
				});
	}

}

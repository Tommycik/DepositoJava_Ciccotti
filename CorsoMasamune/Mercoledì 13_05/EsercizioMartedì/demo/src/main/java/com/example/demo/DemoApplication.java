package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.demo.Services.ProdottoService;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// avvio del programma
		SpringApplication.run(DemoApplication.class, args);
	}

	// bean di command line runner per stampare il catalogo
	@Bean
	CommandLineRunner commandLineRunner(ProdottoService prodottoService) {
		return args -> {
			System.out.println("Inizializzazione prodotti in catalogo");
			System.out.println("Prodotti in catalogo con vari sconti:");
			prodottoService.stampaCatalogo(10);
			prodottoService.stampaCatalogo(20);
		};
	}

}

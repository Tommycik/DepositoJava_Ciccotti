package com.example.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Run.Controller.RunController;
import com.example.demo.Run.Model.Location;
import com.example.demo.Run.Model.Run;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RunController runController) {
		return args -> {
			Run run = new Run("Corsa mattutina al parco", LocalDateTime.of(2024, 3, 1, 7, 0), LocalDateTime.of(2024, 3, 1, 7, 45), 500, Location.OUTDOOR);
		};
	}
}

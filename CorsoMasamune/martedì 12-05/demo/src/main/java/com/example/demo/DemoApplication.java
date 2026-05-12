package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.demo.Run.RunRecord;
import com.example.demo.Run.Location;
import com.example.demo.Services.OrderService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class DemoApplication {
	//non necessario per la demo
	private OrderService orderService;
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		//bean caricati al momento
		System.out.println(context.getBean(WelcomeMessage.class).getMessage());
		System.out.println("Bean registrati");

		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			if(!beanName.contains("org.springframework")){
				System.out.println(beanName);
			}
			
		}
		WelcomeMessage welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getMessage());
		RunRecord runRecord = new RunRecord(1, "Run", LocalDateTime.now(), LocalDateTime.now(), 100, Location.OUTDOOR);
		runRecord.toString();
		System.out.println(runRecord.title());
	}
	@Bean
	CommandLineRunner commandLineRunner(OrderService orderService) {
		return args -> {
			WelcomeMessage welcomeMessage = new WelcomeMessage();
			System.out.println(welcomeMessage.getMessage());
			RunRecord runRecord = new RunRecord(1, "Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 100, Location.INDOOR);
			System.out.println("RUN" +runRecord);
			orderService.processOrder("123456789");
			orderService.processOrder("123456789");
		};
	}
}

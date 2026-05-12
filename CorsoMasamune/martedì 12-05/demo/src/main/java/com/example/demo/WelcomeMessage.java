package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//far riconoscere a spring che questa classe è un componente
@Component
public class WelcomeMessage {
    private String message;
    public String getMessage() {
        return "Welcome to the demo application using spring boot!";
    }
    @PostConstruct
    public void init() {
        message = "Welcome to the demo application using spring boot!";
        System.out.println(message);
    }
    @PreDestroy
    public void destroy() {
        message = "Goodbye from the demo application using spring boot!";
        System.out.println(message);
    }
}

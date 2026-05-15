package com.example.demo.ErrorResponse;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(int id) {
        super("Run con id " + id + " non trovato");
    }
    
}

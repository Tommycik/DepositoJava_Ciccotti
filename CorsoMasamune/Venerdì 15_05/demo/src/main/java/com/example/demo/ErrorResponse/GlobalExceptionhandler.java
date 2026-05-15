package com.example.demo.ErrorResponse;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionhandler {
    //gestisce l'eccezione RunNotFoundException
    @ExceptionHandler(RunNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRunNotFoundException(RunNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(404, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(errorResponse.status()).body(errorResponse);
    }
    //eccezione illegal argument
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(400, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(errorResponse.status()).body(errorResponse);
    }
    //eccezione generica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(500,"Errore nel sistema: " + e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(errorResponse.status()).body(errorResponse);
    }
    
}

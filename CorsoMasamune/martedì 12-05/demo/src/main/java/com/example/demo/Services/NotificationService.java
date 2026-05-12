package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public static void sendConfirmationNotification(String message) {
        System.out.println("Conferma inviata per ordine: " + message);
    }
    
}

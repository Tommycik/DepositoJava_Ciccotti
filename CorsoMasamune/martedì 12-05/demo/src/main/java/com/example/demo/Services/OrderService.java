package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
   /*  //questo non serve più
    //public NotificationService notificationService = new NotificationService();
    private final NotificationService notificationService;
    //iniezione tramite costruttore
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
*/
   private NotificationService notificationService;

   @Autowired
   public void setNotificationService(NotificationService notificationService) {
       this.notificationService = notificationService;
   }
   public void processOrder(String orderId) {
       System.out.println("Processando ordine: " + orderId);
       notificationService.sendConfirmationNotification(orderId);
   }
    
}

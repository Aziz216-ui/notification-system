package com.aziz.notification_system;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    //Server application

    /// app/sendMessage:ca l'url complet
    @MessageMapping("/sendMessage")
    @SendTo("/topic/notifications")
    public String sendMessage(String message){
        System.out.println("message : " + message);
        return message;
    }

    // Mapping pour les mises à jour de commande depuis l'interface admin (order.html)
    // Reçoit les objets OrderUpdate envoyés à /app/order/status et les propage sur /topic/order
    // pour que les clients abonnés (order-user-client.html) les reçoivent
    @MessageMapping("/order/status")
    @SendTo("/topic/order")
    public OrderUpdate orderStatus(OrderUpdate orderUpdate){
        System.out.println("Order update received: " + orderUpdate);
        return orderUpdate;
    }
}

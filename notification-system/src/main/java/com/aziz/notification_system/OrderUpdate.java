package com.aziz.notification_system;

/**
 * Classe représentant une mise à jour de commande
 */
public class OrderUpdate {
    private String orderId;
    private String status;

    // Constructeurs
    public OrderUpdate() {
    }

    public OrderUpdate(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    // Getters et Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderUpdate{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


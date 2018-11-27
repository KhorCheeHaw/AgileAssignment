/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author User
 */
public class Order {
     private int orderId;
    private String name;
    private String date;
    private String pickUpStatus;
    private String paymentStatus;
    private String timestamp;

    
    public Order(int orderId, String name, String date, String pickUpStatus, String paymentStatus, String timestamp) {
        this.orderId = orderId;
        this.name = name;
        this.date = date;
        this.pickUpStatus = pickUpStatus;
        this.paymentStatus = paymentStatus;
        this.timestamp = timestamp;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPickUpStatus() {
        return pickUpStatus;
    }

    public void setPickUpStatus(String pickUpStatus) {
        this.pickUpStatus = pickUpStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
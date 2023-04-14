package com.example.PharmEasy.Admin.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Order")
public class SalesModel {

    private int orderID;
    private String userID;
    private String medicineName;
    private int Quantity;
    private float totalCost;

    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    private String orderDate;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}

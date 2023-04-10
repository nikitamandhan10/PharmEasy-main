package com.example.PharmEasy.Admin.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("inventory")
public class InventoryModel {
    @Id
    private  String id;
    private String medicineID;
    private String medicineName;
    private float cost;
    private int quantity;
    private String lastUpdated;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMedicineID() {
        return medicineID;
    }
    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "InventoryModel{" +
                "medicineID='" + medicineID + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                "lastUpdated" + getLastUpdated() +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Service class - represents a vehicle service
 * @author Administrator
 */
public class Service {
    // Private attributes
    private int serviceId; // Service ID
    private String serviceType; // Service type
    private double cost; // Service cost
    private String mechanicName; // Mechanic name
    private short serviceHours; // Service duration in hours

    // 1. No-argument constructor
    public Service() {
    }

    // 2. Parameterized constructor
    public Service(int serviceId, String serviceType, double cost, String mechanicName, short serviceHours) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.cost = cost;
        this.mechanicName = mechanicName;
        this.serviceHours = serviceHours;
    }

    // 3. Complete getter/setter methods
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public short getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(short serviceHours) {
        this.serviceHours = serviceHours;
    }

    // 4. toString() method
    @Override
    public String toString() {
        return serviceType + " ($" + cost + ")";
    }
}

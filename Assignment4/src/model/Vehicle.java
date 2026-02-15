/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Vehicle class - represents a vehicle
 * @author Administrator
 */
public class Vehicle {
    // Private attributes
    private String vehicleId; // Vehicle ID
    private String make; // Vehicle make/brand
    private String model; // Vehicle model
    private int year; // Vehicle year
    private String registrationNo; // Registration number
    private Owner owner; // Associated owner
    private Service selectedService; // Associated selected service

    // 1. No-argument constructor
    public Vehicle() {
    }

    // 2. Parameterized constructor
    public Vehicle(String vehicleId, String make, String model, int year, String registrationNo, Owner owner, Service selectedService) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNo = registrationNo;
        this.owner = owner;
        this.selectedService = selectedService;
    }

    // 3. Complete getter/setter methods
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    // 4. toString() method
    @Override
    public String toString() {
        return "[" + vehicleId + "] " + make + " " + model + " (" + year + ")";
    }
}

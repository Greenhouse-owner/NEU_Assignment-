/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Business class - manages the entire system
 * @author Administrator
 */
public class Business {
    // Singleton instance
    private static Business instance;
    
    // Vehicle directory
    private VehicleDirectory vehicleDirectory;
    
    // Service catalog
    private ServiceCatalog serviceCatalog;
    
    // Private constructor
    private Business() {
        vehicleDirectory = VehicleDirectory.getInstance();
        serviceCatalog = ServiceCatalog.getInstance();
        initializeData();
    }
    
    // Get singleton instance
    public static Business getInstance() {
        if (instance == null) {
            instance = new Business();
        }
        return instance;
    }
    
    // Get vehicle directory
    public VehicleDirectory getVehicleDirectory() {
        return vehicleDirectory;
    }
    
    // Get service catalog
    public ServiceCatalog getServiceCatalog() {
        return serviceCatalog;
    }
    
    // Initialize data (at least 5 vehicles, with at least 2 of the same make)
    private void initializeData() {
        // Initialize service data
        Service service1 = new Service(1, "Oil Change", 50.0, "John Smith", (short)2);
        Service service2 = new Service(2, "Car Wash", 30.0, "Mike Johnson", (short)1);
        Service service3 = new Service(3, "Tire Replacement", 200.0, "David Lee", (short)3);
        Service service4 = new Service(4, "Brake Inspection", 80.0, "Robert Brown", (short)2);
        Service service5 = new Service(5, "AC Repair", 150.0, "James Wilson", (short)4);
        
        serviceCatalog.addService(service1);
        serviceCatalog.addService(service2);
        serviceCatalog.addService(service3);
        serviceCatalog.addService(service4);
        serviceCatalog.addService(service5);
        
        // Initialize owner and vehicle data (at least 5 vehicles, with at least 2 Toyota)
        Owner owner1 = new Owner(1001, "John", "Doe", LocalDate.of(2024, 1, 15));
        Vehicle vehicle1 = new Vehicle("V001", "Toyota", "Camry", 2020, "ABC12345", owner1, service1);
        
        Owner owner2 = new Owner(1002, "Jane", "Smith", LocalDate.of(2024, 2, 20));
        Vehicle vehicle2 = new Vehicle("V002", "Honda", "Accord", 2021, "DEF67890", owner2, service2);
        
        Owner owner3 = new Owner(1003, "Bob", "Johnson", LocalDate.of(2024, 3, 10));
        Vehicle vehicle3 = new Vehicle("V003", "Toyota", "Corolla", 2019, "GHI11111", owner3, service3);
        
        Owner owner4 = new Owner(1004, "Alice", "Williams", LocalDate.of(2024, 4, 5));
        Vehicle vehicle4 = new Vehicle("V004", "BMW", "X5", 2022, "JKL22222", owner4, service4);
        
        Owner owner5 = new Owner(1005, "Charlie", "Brown", LocalDate.of(2024, 5, 12));
        Vehicle vehicle5 = new Vehicle("V005", "Mercedes", "C-Class", 2023, "MNO33333", owner5, service5);
        
        vehicleDirectory.addVehicle(vehicle1);
        vehicleDirectory.addVehicle(vehicle2);
        vehicleDirectory.addVehicle(vehicle3);
        vehicleDirectory.addVehicle(vehicle4);
        vehicleDirectory.addVehicle(vehicle5);
    }
}


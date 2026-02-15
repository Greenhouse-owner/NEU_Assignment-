/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Catalog management class - Singleton pattern
 * @author Administrator
 */
public class ServiceCatalog {
    // Singleton instance
    private static ServiceCatalog instance;
    
    // Service list
    private List<Service> services;
    
    // Private constructor
    private ServiceCatalog() {
        services = new ArrayList<>();
    }
    
    // Get singleton instance
    public static ServiceCatalog getInstance() {
        if (instance == null) {
            instance = new ServiceCatalog();
        }
        return instance;
    }
    
    // Add service
    public void addService(Service service) {
        services.add(service);
    }
    
    // Get all services
    public List<Service> getAllServices() {
        return new ArrayList<>(services);
    }
    
    // Find service by ID
    public Service findServiceById(int serviceId) {
        for (Service service : services) {
            if (service.getServiceId() == serviceId) {
                return service;
            }
        }
        return null;
    }
    
    // Remove service
    public boolean removeService(int serviceId) {
        Service service = findServiceById(serviceId);
        if (service != null) {
            return services.remove(service);
        }
        return false;
    }
}
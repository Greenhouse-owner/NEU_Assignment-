/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle Directory management class - Singleton pattern
 * @author Administrator
 */
public class VehicleDirectory {
    // Singleton instance
    private static VehicleDirectory instance;
    
    // Vehicle list
    private List<Vehicle> vehicles;
    
    // Private constructor
    private VehicleDirectory() {
        vehicles = new ArrayList<>();
    }
    
    // Get singleton instance
    public static VehicleDirectory getInstance() {
        if (instance == null) {
            instance = new VehicleDirectory();
        }
        return instance;
    }
    
    // Add vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }
    
    // Find vehicle by ID
    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
    
    // Find vehicles by make (returns all matching vehicles)
    public List<Vehicle> findVehiclesByMake(String make) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    
    // Remove vehicle
    public boolean removeVehicle(String vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null) {
            return vehicles.remove(vehicle);
        }
        return false;
    }
    
    // Update vehicle information
    public boolean updateVehicle(String vehicleId, Vehicle updatedVehicle) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null) {
            vehicle.setMake(updatedVehicle.getMake());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setYear(updatedVehicle.getYear());
            vehicle.setRegistrationNo(updatedVehicle.getRegistrationNo());
            vehicle.setOwner(updatedVehicle.getOwner());
            vehicle.setSelectedService(updatedVehicle.getSelectedService());
            return true;
        }
        return false;
    }
}


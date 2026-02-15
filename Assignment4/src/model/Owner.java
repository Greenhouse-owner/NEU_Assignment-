/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Owner class - represents a vehicle owner
 * @author Administrator
 */
public class Owner {
    // Private attributes
    private int ownerId; // Owner ID
    private String firstName; // Owner first name
    private String lastName; // Owner last name
    private LocalDate serviceDate; // Service date
    private boolean isActive; // Owner status

    // 1. No-argument constructor
    public Owner() {
    }

    // 2. Parameterized constructor
    public Owner(int ownerId, String firstName, String lastName, LocalDate serviceDate) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceDate = serviceDate;
        this.isActive = true; // Default status is active
    }

    // 3. Complete getter/setter methods
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // 4. toString() method
    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + ownerId + ")";
    }
}

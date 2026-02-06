/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * @author Administrator
 */
public class Address {
   
    private String country;     
    private String city;         
    private String street;       
    private String postalCode;  
    private int houseNumber;    
    
    
    public Address() {
    }
    
    
    public Address(String country, String city, String street, 
                   String postalCode, int houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
    }
    
   
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public int getHouseNumber() {
        return houseNumber;
    }
    
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    
   
    @Override
    public String toString() {
        return "Address: " + country + ", " + city + ", " + 
               street + " " + houseNumber + ", Postal Code: " + postalCode;
    }
}

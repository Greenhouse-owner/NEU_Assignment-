/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * @author Administrator
 */
public class Person {
   
    private String firstName;      
    private String lastName;       
    private int age;             
    private boolean isMarried;    
    
    
    private Address homeAddress;   
    private Address localAddress;  
    private BankAccount bankAccount; 
    
    
    public Person() {
    }
    
    
    public Person(String firstName, String lastName, int age, boolean isMarried,
                  Address homeAddress, Address localAddress, BankAccount bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.homeAddress = homeAddress;
        this.localAddress = localAddress;
        this.bankAccount = bankAccount;
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean isMarried() {
        return isMarried;
    }
    
    public void setMarried(boolean married) {
        isMarried = married;
    }
    
    public Address getHomeAddress() {
        return homeAddress;
    }
    
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public Address getLocalAddress() {
        return localAddress;
    }
    
    public void setLocalAddress(Address localAddress) {
        this.localAddress = localAddress;
    }
    
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(lastName).append(" ").append(firstName);
        sb.append(", Age: ").append(age);
        sb.append(", Marital status: ").append(isMarried ? "Married" : "Single");
        
        if (homeAddress != null) {
            sb.append("\nHome address: ").append(homeAddress.toString());
        }
        if (localAddress != null) {
            sb.append("\nLocal address: ").append(localAddress.toString());
        }
        if (bankAccount != null) {
            sb.append("\n").append(bankAccount.toString());
        }
        
        return sb.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * @author Administrator
 */
public class BankAccount {
   
    private long accountNumber;    
    private String bankName;       
    private String branchName;    
    private String accountType;    
    private double balance;        
    
    
    public BankAccount() {
    }
    
    
    public BankAccount(long accountNumber, String bankName, String branchName,
                       String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.branchName = branchName;
        this.accountType = accountType;
        this.balance = balance;
    }
    
    
    public long getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public String getBranchName() {
        return branchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    @Override
    public String toString() {
        return "Bank account: " + bankName + " - " + branchName + 
               ", Account number: " + accountNumber + ", Account type: " + accountType + 
               ", Balance: ¥" + String.format("%.2f", balance);
    }
}

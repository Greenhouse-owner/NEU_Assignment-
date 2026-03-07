/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class SupplierSummary {
    
    private Supplier supplier;
    private String supplierName;
    private int totalSalesVolume;
    private double loyaltyScore;
    private double averageSpendPerCustomer;
    private double topFiveSalesShare;
    
    private Map<CustomerProfile, Integer> customerPurchases;
    private int totalCustomerCount;
    
    public SupplierSummary(Supplier supplier, Business business) {
        this.supplier = supplier;
        this.supplierName = supplier.getName();
        this.customerPurchases = new HashMap<>();
        this.totalCustomerCount = business.getCustomerDirectory().getCustomerlist().size();
        this.totalSalesVolume = 0;
        this.loyaltyScore = 0.0;
        this.averageSpendPerCustomer = 0.0;
        this.topFiveSalesShare = 0.0;
        
        calculateMetrics(business);
    }
    
    private void calculateMetrics(Business business) {
        MasterOrderList masterOrderList = business.getMasterOrderList();
        
        // Traverse all orders to collect sales data for this supplier
        for (Order order : masterOrderList.getOrders()) {
            CustomerProfile customer = order.getCustomer();
            
            // Traverse order items
            for (OrderItem item : order.getOrderitems()) {
                Product product = item.getSelectedProduct();
                
                // Check if this product belongs to this supplier
                if (product.getSupplier() != null && product.getSupplier().equals(this.supplier)) {
                    int itemTotal = item.getOrderItemTotal();
                    
                    // Accumulate total sales volume
                    totalSalesVolume += itemTotal;
                    
                    // Record customer purchase amount
                    customerPurchases.put(customer, 
                        customerPurchases.getOrDefault(customer, 0) + itemTotal);
                }
            }
        }
        
        // Calculate loyalty score
        int uniqueCustomerCount = customerPurchases.size();
        if (totalCustomerCount > 0) {
            loyaltyScore = (double) uniqueCustomerCount / totalCustomerCount;
        }
        
        // Calculate average spend per customer
        if (uniqueCustomerCount > 0) {
            averageSpendPerCustomer = (double) totalSalesVolume / uniqueCustomerCount;
        }
        
        // Calculate top five sales share
        calculateTopFiveSalesShare();
    }
    
    private void calculateTopFiveSalesShare() {
        if (customerPurchases.isEmpty() || totalSalesVolume == 0) {
            topFiveSalesShare = 0.0;
            return;
        }
        
        // Convert customer purchase amounts to list and sort in descending order
        List<Integer> amounts = new ArrayList<>(customerPurchases.values());
        Collections.sort(amounts, Collections.reverseOrder());
        
        // Calculate total of top 5 customers
        int topFiveTotal = 0;
        int count = Math.min(5, amounts.size());
        for (int i = 0; i < count; i++) {
            topFiveTotal += amounts.get(i);
        }
        
        // Calculate share
        topFiveSalesShare = (double) topFiveTotal / totalSalesVolume;
    }
    
    // Getter methods
    public String getSupplierName() {
        return supplierName;
    }
    
    public int getTotalSalesVolume() {
        return totalSalesVolume;
    }
    
    public double getLoyaltyScore() {
        return loyaltyScore;
    }
    
    public double getAverageSpendPerCustomer() {
        return averageSpendPerCustomer;
    }
    
    public double getTopFiveSalesShare() {
        return topFiveSalesShare;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }
}


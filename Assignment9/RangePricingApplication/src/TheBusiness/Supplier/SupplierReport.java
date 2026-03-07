/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kal bugrara
 */
public class SupplierReport {
    
    private ArrayList<SupplierSummary> supplierSummaries;
    
    public SupplierReport() {
        supplierSummaries = new ArrayList<>();
    }
    
    public void addSupplierSummary(SupplierSummary summary) {
        supplierSummaries.add(summary);
    }
    
    public ArrayList<SupplierSummary> getSummaries() {
        return supplierSummaries;
    }
    
    public ArrayList<SupplierSummary> getSortedByRevenue() {
        ArrayList<SupplierSummary> sorted = new ArrayList<>(supplierSummaries);
        Collections.sort(sorted, new Comparator<SupplierSummary>() {
            @Override
            public int compare(SupplierSummary s1, SupplierSummary s2) {
                return s2.getTotalSalesVolume() - s1.getTotalSalesVolume();
            }
        });
        return sorted;
    }
    
    public ArrayList<SupplierSummary> getSortedByLoyalty() {
        ArrayList<SupplierSummary> sorted = new ArrayList<>(supplierSummaries);
        Collections.sort(sorted, new Comparator<SupplierSummary>() {
            @Override
            public int compare(SupplierSummary s1, SupplierSummary s2) {
                return Double.compare(s2.getLoyaltyScore(), s1.getLoyaltyScore());
            }
        });
        return sorted;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Business;

import MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketModel.ChannelCatalog;
import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductsReport;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.Supplier.SupplierReport;
import TheBusiness.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role
    MasterOrderList masterorderlist;
    CustomerDirectory customers;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    MarketChannelComboCatalog marketChannelComboCatalog;
    SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    MasterSolutionOrderList mastersolutionorderlist;


    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();

        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory();

        marketcatalog = new MarketCatalog();

        channelcatalog = new ChannelCatalog();

//        Channel c = channelcatalog.newChannel("tv");
//        market.addValidChannel(c);
//        c = channelcatalog.newChannel("");

        marketChannelComboCatalog = new MarketChannelComboCatalog();
//        MarketChannelAssignment mca2 = marketChannelComboCatalog.newMarketChannelCombo(market, c);

        solutionoffercatalog = new SolutionOfferCatalog();
        mastersolutionorderlist  = new MasterSolutionOrderList();

    }
  
    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }

    public MarketCatalog getMarketCatalog() {
        return marketcatalog;
    }

    public ChannelCatalog getChannelCatalog() {
        return channelcatalog;
    }
    public SolutionOfferCatalog getSolutionOfferCatalog(){
        return solutionoffercatalog;
    }
    public MarketChannelComboCatalog getMarketChannelComboCatalog() {

        return marketChannelComboCatalog;
    }
    public MasterSolutionOrderList getMasterSolutionOrderList(){
        return mastersolutionorderlist;
    }
    
    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }
    
    public ArrayList<Product> getMostExpensiveProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        
        // Collect all products from all suppliers
        for (Supplier supplier : suppliers.getSuplierList()) {
            allProducts.addAll(supplier.getProductCatalog().getProductList());
        }
        
        // Sort by target price in descending order
        allProducts.sort((p1, p2) -> p2.getTargetPrice() - p1.getTargetPrice());
        
        return allProducts;
    }
    
    public ArrayList<CustomerProfile> getMostValuableCustomers() {
        ArrayList<CustomerProfile> customers = new ArrayList<>(customerdirectory.getCustomerlist());
        
        // Sort by total sales amount in descending order
        customers.sort((c1, c2) -> c2.getTotalSalesAmount() - c1.getTotalSalesAmount());
        
        return customers;
    }
    
    public SupplierReport getSupplierAnalysisReport() {
        return suppliers.generateSupplierReport(this);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");
        Random random = new Random();

        // Phase 1: Preparation - Create Random object for data generation
        
        // Phase 2: Create base persons and customers
        
        // Step 2.1: Create base persons for sales, marketing, and admin
        PersonDirectory persondirectory = business.getPersonDirectory();
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox Sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox Marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox Admin");

        // Step 2.2: Create 300 customers
        CustomerDirectory customerdirectory = business.getCustomerDirectory();
        CustomerProfile[] customers = new CustomerProfile[300];
        for (int i = 0; i < 300; i++) {
            Person customerPerson = persondirectory.newPerson("Customer_" + (i + 1));
            customers[i] = customerdirectory.newCustomerProfile(customerPerson);
        }

        // Step 2.3: Create Sales people
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

        // Step 2.4: Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

        // Step 2.5: Create Employee (Admin) profile
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

        // Phase 1-2 Complete: Base persons and 300 customers created
        
        // Phase 3: Create suppliers and products
        
        // Step 3.1: Create 50 suppliers
        SupplierDirectory supplierdirectory = business.getSupplierDirectory();
        Supplier[] suppliers = new Supplier[50];
        for (int i = 0; i < 50; i++) {
            suppliers[i] = supplierdirectory.newSupplier("Supplier_" + (i + 1));
        }
        
        // Step 3.2: Create products for first 30 suppliers (30 suppliers x 50 products = 1500 products)
        Product[][] allProducts = new Product[30][50];
        String[] productTypes = {"Scanner", "Printer", "Photocopier", "Fax Machine", "Plotter", 
                                 "Copier", "Multifunction Device", "Laser Printer", 
                                 "Inkjet Printer", "3D Printer"};
        
        for (int i = 0; i < 30; i++) {
            ProductCatalog catalog = suppliers[i].getProductCatalog();
            
            for (int j = 0; j < 50; j++) {
                String productType = productTypes[j % productTypes.length];
                int basePrice = 1000 + (i * 500) + (j * 100);
                int floorPrice = basePrice;
                int targetPrice = basePrice + 5000 + random.nextInt(3000);
                int ceilingPrice = targetPrice + 5000 + random.nextInt(5000);
                
                allProducts[i][j] = catalog.newProduct(
                    productType + " Model " + (i + 1) + "-" + (j + 1), 
                    floorPrice, 
                    ceilingPrice, 
                    targetPrice
                );
            }
        }
        
        // Phase 3 Complete: 50 suppliers and 1500 products created

        // Phase 4: Create user accounts
        
        // Step 4.1: Create user accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "sales", "XXXX");
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX");
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "XXXX");
        
        // Phase 4 Complete: User accounts created
        
        // Phase 5: Create orders and order items
        
        // Step 5.1: Create orders for each customer (1-3 orders per customer, 10 items per order)
        MasterOrderList masterorderlist = business.getMasterOrderList();
        
        for (int i = 0; i < 300; i++) {
            int orderCount = 1 + random.nextInt(3); // Random 1-3 orders per customer
            
            for (int j = 0; j < orderCount; j++) {
                Order order = masterorderlist.newOrder(customers[i], salespersonprofile);
                
                // Add exactly 10 order items to each order
                for (int k = 0; k < 10; k++) {
                    int supplierIndex = random.nextInt(30); // Only from first 30 suppliers with products
                    int productIndex = random.nextInt(50);
                    Product product = allProducts[supplierIndex][productIndex];
                    
                    // Generate actual price between floor and ceiling
                    int priceRange = product.getCeilingPrice() - product.getFloorPrice();
                    int actualPrice = product.getFloorPrice() + random.nextInt(priceRange + 1);
                    
                    // Random quantity between 1 and 5
                    int quantity = 1 + random.nextInt(5);
                    
                    order.newOrderItem(product, actualPrice, quantity);
                }
            }
        }
        
        // Phase 5 Complete: Orders and order items created
        
        // Phase 6: Print statistics
        
        // Calculate total orders created
        int totalOrders = 0;
        for (int i = 0; i < 300; i++) {
            // Count orders for statistics (already created in Phase 5)
        }
        // Note: Actual order count is stored in masterorderlist
        
        System.out.println("=================================================");
        System.out.println("=== Business Initialization Complete ===");
        System.out.println("=================================================");
        System.out.println("Business Name: Xerox");
        System.out.println("-------------------------------------------------");
        System.out.println("Total Suppliers: 50");
        System.out.println("Suppliers with Products: 30");
        System.out.println("Total Products: 1500 (30 suppliers x 50 products)");
        System.out.println("-------------------------------------------------");
        System.out.println("Total Customers: 300");
        System.out.println("Total Sales Persons: 1");
        System.out.println("Total Marketing Persons: 1");
        System.out.println("Total Admin Persons: 1");
        System.out.println("Total User Accounts: 3");
        System.out.println("-------------------------------------------------");
        System.out.println("Orders Created: 300-900 (1-3 per customer)");
        System.out.println("Order Items per Order: 10");
        System.out.println("Expected Total Order Items: 3000-9000");
        System.out.println("-------------------------------------------------");
        System.out.println("Data Generation Method: Random");
        System.out.println("=================================================");
        
        // Phase 6 Complete: All phases finished successfully
        
        return business;
    }

}

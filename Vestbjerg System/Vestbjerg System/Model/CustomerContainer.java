package Model;

import java.util.ArrayList;
public class CustomerContainer {
    private ArrayList<Product> customers;
    private static CustomerContainer instance;
    private CustomerContainer() {
        customers = new ArrayList<>();
    }
    
    public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }
    public Customer getCustomerByNameContains() {
        
        
    }
    public ArrayList<Product> getCustomers() {
        return customers;
    }
    public void addCustomer(Product customer) {
        customers.add(customer);
    }
}
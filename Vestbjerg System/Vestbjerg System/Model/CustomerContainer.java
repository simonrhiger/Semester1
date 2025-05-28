package Model;

import java.util.ArrayList;
public class CustomerContainer {
    private ArrayList<Customer> customers;
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
    public ArrayList<Customer> getCustomerByNameContains() {
       ArrayList<SimpleProduct> result = new ArrayList<>();
       
        for (Customer c : customers){
            if (c.getName().contains(searchString)){
                result.add(c);
            }
        }
    
        return result;
    }
    }
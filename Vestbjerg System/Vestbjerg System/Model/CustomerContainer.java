package Model;
import java.util.ArrayList;

/**
 * This class contains a list of all customers.
 */
public class CustomerContainer {
    private ArrayList<Customer> customers;
    private static CustomerContainer instance;
    
    /**
     * Constructor for objects of class CustomerContainer.
     */
    private CustomerContainer() {
        customers = new ArrayList<>();
    }
    
    /**
     * Singleton.
     */
    public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    /**
     * Adds customer to ArrayList
     */
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    /**
     * Finds every customer in container that contains search term and returns an array of customers.
     */
    public ArrayList<Customer> getCustomerByNameContains(String searchString) {
       ArrayList<Customer> result = new ArrayList<>();
       
        for (Customer c : customers){
            if (c.getName().contains(searchString)){
                result.add(c);
            }
        }
    
        return result;
    }
}
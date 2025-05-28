package Controller;
import Model.*;
import java.util.*;


public class CustomerController
{
    
    public CustomerController()
    {
        
    }
    
    public ArrayList<Customer> findCustomerByNameContains(String searchString){
        return CustomerContainer.getInstance().getCustomerByNameContains(searchString);
    }
}

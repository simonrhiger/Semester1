package Controller;
import Model.*;
import java.util.*;

/**
 * This controller class handles customers.
 */
public class CustomerController {
    /**
     * This method returns list of products from the container
     */
    public ArrayList<Customer> findCustomerByNameContains(String searchString) {
        return CustomerContainer.getInstance().getCustomerByNameContains(searchString);
    }
}

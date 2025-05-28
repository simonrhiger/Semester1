package Controller;
import Model.*;
import java.util.ArrayList;

/**
 * This class handles orders.
 */
public class OrderController
{
    private CustomerController customerController;
    private ProductController productController;
    private Order currentOrder;
    
    /**
     * cosntructor for objects of OrderController.
     */
    public OrderController() {
        productController = new ProductController();
        customerController = new CustomerController();
    }
    
    /**
     * creates new order object an assigns it as the current order being processed.
     */
    public void makeNewOrder(String status, int orderNo, String orderDate) {
        currentOrder = new Order(status, orderNo, orderDate);
    }
    /**
     * returns a list of products matching search.
     */
    public ArrayList<SimpleProduct> searchProducts(String searchString) {
        return productController.findProductByNameContains(searchString);
    }
    
    /**
     * adds product to order.
     */
    public void addProduct(SimpleProduct product, int quantity) {
        currentOrder.addProduct(product, quantity);
    }
    
    /**
     * returns a list of customers matching search.
     */
    public ArrayList<Customer> searchCustomer(String searchString) {
        return customerController.findCustomerByNameContains(searchString);
    }
    
    /**
     * adds customer to order.
     */
    public void selectCustomer(Customer customer) {
        currentOrder.setCustomer(customer);
    }
    
    /**
     * adds order to container.
     */
    public void confirmOrder() {
        OrderContainer.getInstance().addOrder(currentOrder);
    }
}

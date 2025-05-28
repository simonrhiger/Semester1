package Model;
import java.util.ArrayList;

/**
 * this class represents orders.
 *
 * @author Karen Romo
 * @version 26/05/2025
 */
public class Order {
    private String status;
    private int orderNo;
    private String orderDate;
    private ArrayList<Orderline> orderlines;
    private Customer customer;
    
    /**
     * Constructor for objects of class Order.
     */
    public Order(String status, int orderNo, String orderDate) {
        this.status = status;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        orderlines = new ArrayList<Orderline>();
    }
    
    /**
     * add product to ordeline and add orderlien to list of orderlines.
     */
    public void addProduct(SimpleProduct product, int quantity) {
        Orderline line = new Orderline(product, quantity, 0);
        orderlines.add(line);
    }
    
    /**
     * Sets customer.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    /**
     * Returns total price.
     */
    public double getTotalPrice() {
        double result = 0;
        
        for (Orderline ol : orderlines){
            result += ol.getPrice();
        }
        
        return result;
    }
}

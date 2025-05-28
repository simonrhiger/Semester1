package Model;
import java.util.ArrayList;

/**
 * Write a description of class Order here.
 *
 * @author Karen Romo
 * @version 26/05/2025
 */
public class Order
{
    private String status;
    private int orderNo;
    private String orderDate;
    private ArrayList<Orderline> orderlines;
    private Customer customer;
    
    public Order(String status, int orderNo, String orderDate)
    {
        this.status = status;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        orderlines = new ArrayList<Orderline>();
    }
    
    public void addProduct(SimpleProduct product, int quantity)
    {
        Orderline line = new Orderline(product, quantity, 0);
        orderlines.add(line);
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public double getTotalPrice(){
        double result = 0;
        
        for (Orderline ol : orderlines){
            result += ol.getPrice();
        }
        
        return result;
    }
}

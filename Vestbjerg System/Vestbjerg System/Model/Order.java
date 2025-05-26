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
    private double totalPrice;
    private String oderDate;
    private ArrayList<Orderline> orderline;
    
    public Order (String status, int orderNo, double totalPrice, String orderDate)
    {
        this.status = status;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.oderDate = orderDate;
        this.orderline = new ArrayList<Orderline>();
    }
    
    public void addProduct (SimpleProduct product)
    {
        double price = 0;
        double discount = 0;
        Orderline line = new Orderline(1, price,discount);
        this.orderline.add(line);
    }
    
    
}

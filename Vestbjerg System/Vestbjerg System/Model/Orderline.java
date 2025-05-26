package Model;


/**
 * Write a description of class Orderline here.
 *
 * @author Karen Romo
 * @version 26/05/2025
 */
public class Orderline
{
    private int quantity;
    private double price;
    private double discount;
    
    public Orderline (int quantity, double price, double discount)
    {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }
    
    //Getters//
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double discount()
    {
        return discount;
    }
}

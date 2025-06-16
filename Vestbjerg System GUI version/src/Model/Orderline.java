package Model;


/**
 * Write a description of class Orderline here.
 *
 * @author Karen Romo
 * @version 26/05/2025
 */
public class Orderline
{
    private SimpleProduct product;
    private int quantity;
    private double discount;
    
    public Orderline (SimpleProduct product, int quantity, double discount)
    {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }
    
    //Getters//
    public int getQuantity()
    {
        return quantity;
    }
    
    public double discount()
    {
        return discount;
    }
    
    public double getPrice(){
        return product.getCostPrice() * quantity;
    }
}

package Model;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======

import java.util.ArrayList;
public class OrderContainer {
	private ArrayList<Order> orders;
	private static OrderContainer instance;
	
private OrderContainer(){
	orders = new ArrayList<>();
	
}
	
	public static OrderContainer getInstance() {
		if(instance==null) {
			instance = new OrderContainer();
		}
		return instance; 
	}
	public void saveOrder(Order order) {
		orders.add(orders);
    }
   public ArrayList<Order> getAllOrders(){
	   return orders; 
>>>>>>> Stashed changes

>>>>>>> Stashed changes
import java.util.ArrayList;

/**
 * This class contains a list of all simple products.
 */
public class OrderContainer {
    private ArrayList<Order> orders;
    private static OrderContainer instance;
    
    private OrderContainer(){
        orders = new ArrayList<>();        
    }
    
    /**
     * Singleton.
     */
    public static OrderContainer getInstance() {
        if(instance==null) {
            instance = new OrderContainer();
        }
        return instance; 
    }
    
    /**
     * Adds order to ArrayList
     */
    public void addOrder(Order order) {
        orders.add(order);
    }
}

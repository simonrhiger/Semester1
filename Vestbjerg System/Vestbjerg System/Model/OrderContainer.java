package Model;
import java.util.ArrayList;

/**
 * This class contains a list of all orders.
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

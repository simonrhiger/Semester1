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

   }
}

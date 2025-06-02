package UI;
import Controller.*;
import Model.*;

public class TryMe
{
    
    public TryMe()
    {
        SimpleProduct product1 = new SimpleProduct(1, "Hammer", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a-20-20");
        SimpleProduct product2 = new SimpleProduct(1, "Skruetrækker", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a-20-20");
        SimpleProductContainer.getInstance().addProduct(product1);
        SimpleProductContainer.getInstance().addProduct(product2);
        
        Customer customer1 = new Customer("Bob", "a", "a", "a");
        CustomerContainer.getInstance().addCustomer(customer1);
        
        UI ui = new UI();
        ui.makeNewOrder();
    }
}

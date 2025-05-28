package UI;
import Controller.*;
import Model.*;
import java.util.ArrayList;

public class UI
{
    private OrderController orderController;
    private ArrayList<SimpleProduct> productList;
    private ArrayList<Customer> customerList;
    
    public UI() {
        orderController = new OrderController();
        productList = new ArrayList<>();
        customerList = new ArrayList<>();
    }
    
    public void makeNewOrder() {
        //TO-DO: 
        //1. kalder makeNewOrder i orderController.
        //2. et loop der gentager nedestående indtil bruger trykker videre.
            //2.1. kalder searchProducts.
            //2.2. kalder addProductToOrder.
            //2.3. spørger brugeren om de er færdige med at tilføje produkter, gentag loop eller videre.
        //3. kalder searchCustomers.
        //4. kalder selectCustomer.
        //5. kalder confirmOrder
    }
    
    public void searchProducts() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
        //2. finder en liste af produkter via controller.searchProducts.
        //3. tilføjer listen til productList.
        //4. viser/printer productlist.
    }
    
    public void addProductToOrder() {
        //TO-DO:
        //1. spørger brugeren efter hvilket produkt de vil tilføje.
        //2. kalder addproduct i controller.
    }
    
    public void showOrderList() {
        //denne funktion kan vi vel ikke lave med et TUI? kun med GUI...
    }
    
    public void searchCustomers() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
        //2. finder en liste af kunder via controller.searchProducts.
        //3. tilføjer listen til customerList.
        //4. viser/printer customerlist.
    }
    
    public void selectCustomer() {
        //TO-DO:
        //1. spørger brugeren efter hvilken kunde de vil vælge.
        //2. kalder selectCustomer i controller.
    }
    
    public void confirmOrder() {
        //TO-DO:
        //1. spørger brugeren om de vil bekræfte.
        //2. kalder controller.confirmOrder.
    }
}

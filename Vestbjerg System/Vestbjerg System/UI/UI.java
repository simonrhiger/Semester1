package UI;
import Controller.*;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

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
        orderController.makeNewOrder("Unprocessed", (int)(Math.random()), LocalDate.now());
        boolean addingProducts = true;
        //2. et loop der gentager nedestående indtil bruger trykker videre.
        while(addingProducts) {
            //2.1. kalder searchProducts.
            searchProducts();
            //2.2. kalder addProductToOrder.
            addProductToOrder();
            //2.3. spørger brugeren om de er færdige med at tilføje produkter, gentag loop eller videre.
            System.out.println("Vil du tilføje flere produkter til ordre ja/nej");
            Scanner scanner= new Scanner(System.in);
            String svar= scanner.nextLine().toLowerCase();
            if(!svar.equals("ja")) {
                addingProducts = false;
            }
        }
        
        //3. kalder searchCustomers.
            searchCustomers();
            //4. kalder selectCustomer.
            selectCustomer();
            //5. kalder confirmOrder
            confirmOrder();
           
    }
    
    public void searchProducts() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
        Scanner scanner= new Scanner(System.in);
        System.out.println("Hvilke produkt søger du");
        String searchString = scanner.nextLine();
        //2. finder en liste af produkter via controller.searchProducts. //3. tilføjer listen til productList.
        productList.clear();
        productList = orderController.searchProducts(searchString);
        //4. viser/printer productlist.
        if (productList.isEmpty()) {
            System.out.println("Ingen produkter fundet med søgeordet: " + searchString);
        } else {
            System.out.println("Produkter fundet:");
            int i = 0;
            while (i < productList.size()) {
                System.out.println(i + ") " + productList.get(i).getName());
                i++;
            }
        }
  
    }
    
    public void addProductToOrder() {
        //TO-DO:
        //1. spørger brugeren efter hvilket produkt de vil tilføje.
        System.out.println("Hvilke produkt vil du tilføje til ordre");
        Scanner scanner = new Scanner(System.in);
        int product = scanner.nextInt();
        //spørger brugeren om antal
        System.out.println("Hvor mange stk.?");
        int quantity = scanner.nextInt();
        //2. kalder addproduct i controller.
        orderController.addProduct(productList.get(product), quantity);
    }
    
    public void showOrderList() {
        //denne funktion kan vi vel ikke lave med et TUI? kun med GUI...
    }
    
    public void searchCustomers() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
        Scanner scanner= new Scanner(System.in);
        System.out.println("Indtast kunde navn.");
        String searchString = scanner.nextLine();
        //2. finder en liste af kunder via controller.searchCustomers. 3. tilføjer listen til customerList.
        customerList.clear();
        customerList = orderController.searchCustomer(searchString);
        //4. viser/printer customerlist.
        if (customerList.isEmpty()) {
            System.out.println("Ingen kunder fundet med søgeordet: " + searchString);
        } else {
            int i = 0;
            while (i < customerList.size()) {
                System.out.println(i + ") " + customerList.get(i).getName());
                i++;
            }
        }
    }
    
    public void selectCustomer() {
        //TO-DO:
        //1. spørger brugeren efter hvilken kunde de vil vælge.
        System.out.println("Hvilke kunde vil du tilføje til ordren?");
        Scanner scanner = new Scanner(System.in);
        int customer = scanner.nextInt();
        //2. kalder selectCustomer i controller.
        orderController.selectCustomer(customerList.get(customer));
    }
    
    public void confirmOrder() {
        //TO-DO:
        //1. spørger brugeren om de vil bekræfte.
        System.out.println("Bekræft ordre ja/nej");
        Scanner scanner= new Scanner(System.in);
        String svar= scanner.nextLine().toLowerCase();
        if(!svar.equals("ja")) {
            orderController.confirmOrder();
        }
    }
}

package UI;
import Controller.*;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * This class handles the text based UI.
 */
public class UI {
    private OrderController orderController;
    private ArrayList<SimpleProduct> productList;
    private ArrayList<Customer> customerList;
    private Scanner scanner;
    
    public UI() {
        orderController = new OrderController();
        productList = new ArrayList<>();
        customerList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void makeNewOrder() {       
        orderController.makeNewOrder("Unprocessed", (int)(Math.random()), LocalDate.now());
        boolean addingProducts = true;
        
        while(addingProducts) {
            searchProducts();
            addProductToOrder();
            System.out.println("Vil du tilføje flere produkter til ordre ja/nej");
            String svar = scanner.nextLine().toLowerCase();
            if(!svar.equals("ja")) {
                addingProducts = false;
            }
        }
        
        searchCustomers();
        selectCustomer();
        confirmOrder();           
    }
    
    public void searchProducts() {
        System.out.println("Hvilke produkt søger du");
        String searchString = scanner.nextLine().toLowerCase();
        productList.clear();
        productList = orderController.searchProducts(searchString);
        
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
        System.out.println("Hvilke produkt vil du tilføje til ordre");
        int product = scanner.nextInt();
        System.out.println("Hvor mange stk.?");
        int quantity = scanner.nextInt();
        orderController.addProduct(productList.get(product), quantity);
    }
    
    public void showOrderList() {
        //denne funktion er til GUI.
    }
    
    public void searchCustomers() {
        System.out.println("Indtast kunde navn.");
        String searchString = scanner.nextLine().toLowerCase();
        customerList.clear();
        customerList = orderController.searchCustomer(searchString);
        
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
        System.out.println("Hvilke kunde vil du tilføje til ordren?");
        int customer = scanner.nextInt();
        orderController.selectCustomer(customerList.get(customer));
    }
    
    public void confirmOrder() {
        System.out.println("Bekræft ordre ja/nej");
        String svar = scanner.nextLine().toLowerCase();
        if(!svar.equals("ja")) {
            orderController.confirmOrder();
        }
    }
}

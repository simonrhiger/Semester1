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
    }
    
    public void makeNewOrder() {       
        orderController.makeNewOrder("Unprocessed", (int)(Math.random()), LocalDate.now());
        boolean addingProducts = true;
        
        while(addingProducts) {
            searchProducts();
            addProductToOrder();
            System.out.println("Vil du tilføje flere produkter til ordren?");
            System.out.println("0) Ja");
            System.out.println("1) Nej");
            int svar = forceInt(1);
            if(svar == 1) {
                addingProducts = false;
            }
        }
        
        searchCustomers();
        selectCustomer();
        confirmOrder();           
    }
    
    public void searchProducts() {
        productList.clear();
        System.out.println("Hvilket produkt søger du?");
        scanner = new Scanner(System.in);
        String searchString = scanner.nextLine().toLowerCase();
        productList = orderController.searchProducts(searchString);
        
        if (productList.isEmpty()) {
            System.out.println("Ingen produkter fundet med søgeordet: " + searchString + " , prøv igen.");
            searchProducts();
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
        SimpleProduct product = productList.get(forceInt(productList.size() - 1));
        
        System.out.println("Hvor mange stk.?");
        int quantity = forceInt(99);
        
        orderController.addProduct(product, quantity);
    }
    
    public void showOrderList() {
        //denne funktion er til GUI.
    }
    
    public void searchCustomers() {
        customerList.clear();
        System.out.println("Indtast kunde navn.");
        scanner = new Scanner(System.in);
        String searchString = scanner.nextLine().toLowerCase();        
        customerList = orderController.searchCustomer(searchString);
        
        if (customerList.isEmpty()) {
            System.out.println("Ingen kunder fundet med søgeordet: " + searchString + " , prøv igen.");
            searchCustomers();
        } else {
            System.out.println("Kunder fundet:");
            int i = 0;
            
            while (i < customerList.size()) {
                System.out.println(i + ") " + customerList.get(i).getName());
                i++;
            }
        }
    }
    
    public void selectCustomer() {
        System.out.println("Hvilke kunde vil du tilføje til ordren?");
        Customer customer = customerList.get(forceInt(customerList.size() - 1));
        orderController.selectCustomer(customer);
    }
    
    public void confirmOrder() {
        System.out.println("Bekræft ordre.");
        System.out.println("0) Ja");
        System.out.println("1) Nej");
        
        switch (forceInt(1)) {
            case 0:
                orderController.confirmOrder();
                System.out.println("Ordre bekræftet. Tak for denne gang.");
                break;
            case 1:
                System.out.println("Ordre annulleret. Tak for denne gang.");
                break;
            }
    }
    
    public int forceInt(int max) {
        int result = 0;
        scanner = new Scanner(System.in);
        
        while (!scanner.hasNextInt() ) 
        {        
            scanner.next();
            System.out.println("Skriv et tal.");
        }
        
        result = scanner.nextInt();
        
        if (result < 0 || result > max) {
            System.out.println("Tal ikke gyldigt, prøv igen.");
            result = forceInt(max);
        }
        
        return result;
    }
}

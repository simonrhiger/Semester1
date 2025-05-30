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
    	orderController.makeNewOrder();
    	boolean tilføjProdukterTilOrder = true;
        //2. et loop der gentager nedestående indtil bruger trykker videre.
    	while(tilføjProdukterTilOrder) {
    		//2.1. kalder searchProducts.
    		searchProducts();
    		//2.2. kalder addProductToOrder.
    		addProductToOrder();
    		//2.3. spørger brugeren om de er færdige med at tilføje produkter, gentag loop eller videre.
    		System.out.println("Vil du tilføje flere produkter til ordre ja/nej");
    		String svar= scanner.nextLine().toLowerCase();
    		if(!svar.equals("ja")) {
    			tilføjProdukterTilOrder = false;
    		}
    		//3. kalder searchCustomers.
    		searchCustomers();
    		//4. kalder selectCustomer.
    		selectCustomer();
    		//5. kalder confirmOrder
    		confirmOrder();
    		
    		
    	}
           
    }
    
    public void searchProducts() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
    	Scanner scanner= new scanner(System.in);
    	System.out.println("Hvilke produkt søger du");
    	String søgtProdukt = scanner.nextLine();
        //2. finder en liste af produkter via controller.searchProducts.
    	List<Produkt> fundneProdukter = orderController.searchProducts(søgeord);

        //3. tilføjer listen til productList.
    	productList.clear();
        productList.addAll(fundneProdukter);
        //4. viser/printer productlist.
        if (productList.isEmpty()) {
            System.out.println("Ingen produkter fundet med søgeordet: " + søgeord);
        } else {
            System.out.println("Produkter fundet:");
            int i = 0;
            while (i < productList.size()) {
                Produkt p = productList.get(i);
                System.out.println(p);
                i++;
            }
        }
  
    }
    
    public void addProductToOrder() {
        //TO-DO:
        //1. spørger brugeren efter hvilket produkt de vil tilføje.
    	System.out.println("Hvilke produkt vil du tilføje til ordre");
    	Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        //2. kalder addproduct i controller.
    	orderController.addProductToorder(product);
    }
    
    public void showOrderList() {
        //denne funktion kan vi vel ikke lave med et TUI? kun med GUI...
    }
    
    public void searchCustomers() {
        //TO-DO:
        //1. spørger brugeren efter søgeord.
    	System.out.println("Kunde navn:");
        //2. finder en liste af kunder via controller.searchProducts.
    	orderController.searchCustomer();
        //3. tilføjer listen til customerList.
    	
        //4. viser/printer customerlist.
    }
    
    public void selectCustomer() {
        //TO-DO:
        //1. spørger brugeren efter hvilken kunde de vil vælge.
    	System.out.println("Tilføj kunde til ordre");
        //2. kalder selectCustomer i controller.
    	orderController.selectCustomer();
    }
    
    public void confirmOrder() {
        //TO-DO:
        //1. spørger brugeren om de vil bekræfte.
    	System.out.println("Bekræft ordre")
    	//2. kalder controller.confirmOrder.
    	orderController.confirmOrder();
    }
}

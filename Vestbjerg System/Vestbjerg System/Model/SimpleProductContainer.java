package Model;
import java.util.ArrayList;

/**
 * This class contains a list of all simple products.
 */
public class SimpleProductContainer{
    private ArrayList<SimpleProduct> products;
    private static SimpleProductContainer instance;
    
    private SimpleProductContainer(){
        products = new ArrayList<>();
    }
    
    /**
     * Singleton.
     */
    public static SimpleProductContainer getInstance(){
        if (instance == null){
            instance = new SimpleProductContainer();
        }
        return instance;
    }
    
    /**
     * Adds product to ArrayList
     */
    public void addProduct(SimpleProduct product){
        products.add(product);
    }
    
    /**
     * Finds every product in container that contains search term and returns as array of products.
     */
    public ArrayList<SimpleProduct> findProductByNameContains(String searchString){
        ArrayList<SimpleProduct> result = new ArrayList<>();
        
        for (SimpleProduct sp : products){
            if (sp.getName().contains(searchString)){
                result.add(sp);
            }
        }
        
        return result;
    }
}

package Model;
import java.util.ArrayList;

/**
 * This class contains a lsit of all simple products.
 */

public class SimpleProductContainer
{
    private ArrayList<SimpleProduct> products;
    private SimpleProductContainer instance;
    
    private SimpleProductContainer(){
        products = new ArrayList<>();
    }
    
    /**
     * Singleton.
     */
    public SimpleProductContainer getInstance(){
        if (instance == null){
            instance = new SimpleProductContainer();
        }
        return instance;
    }
    
    /**
     * Finds every product in container that contains search term and returns as array of products.
     */
    public SimpleProduct[] findProductByNameContains(String searchString){
        SimpleProduct[] result = new ArrayList<>();
        
        for (SimpleProduct sp : products){
            if (sp.getName().contains(searchString)){
                result.add(sp);
            }
        }
        
        return result;
    }
}

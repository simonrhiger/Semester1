package Model;
import java.util.ArrayList;

public class SimpleProductContainer
{
    private ArrayList<SimpleProduct> products;
    private SimpleProductContainer instance;
    
    private SimpleProductContainer(){
        products = new ArrayList<>();
    }
    
    public SimpleProductContainer getInstance(){
        if (instance == null){
            instance = new SimpleProductContainer();
        }
        return instance;
    }
    
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

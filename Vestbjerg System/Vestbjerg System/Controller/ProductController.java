package Controller;
import Model.*;
import java.util.ArrayList;

/**
 * This controller class handles Products.
 */
public class ProductController {
    /**
     * This method returns list of products from the container
     */
    public ArrayList<SimpleProduct> findProductByNameContains(String searchString){
        return SimpleProductContainer.getInstance().findProductByNameContains(searchString);
    }
}

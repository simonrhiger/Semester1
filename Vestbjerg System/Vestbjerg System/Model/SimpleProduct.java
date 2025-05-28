package Model;

/**
 * Class SimpleProduct with all of the attributes of a simple product
 *
 * @author Lilja
 * @version 26-05-2025
 */
public class SimpleProduct
{
    // instance variables
    private int productID;
    private String productName;
    private String manufacturer;
    private String model;
    private String description;
    private String category;
    private double salesPrice;
    private double costPrice;
    private double retailReturnPrice;
    private int tradeAllowance;
    private int inventoryQuantity;
    private int supplierID;
    private String sku;

    /**
     * Constructor for objects of class SimpleProduct
     */
    public SimpleProduct(int productID, String productName, String manufacturer, String model, String description, String category, double salesPrice, double costPrice, double retailReturnPrice, int tradeAllowance, int inventoryQuantity, int supplierID, String sku){
        this.productID = productID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.category = category;
        this.salesPrice = salesPrice;
        this.costPrice = costPrice;
        this.retailReturnPrice = retailReturnPrice;
        this.tradeAllowance = tradeAllowance;
        this.inventoryQuantity = inventoryQuantity;
        this.supplierID = supplierID;
        this.sku = sku;
    }
    
    public String getName(){
        return productName;
    }
    
    public double getCostPrice(){
        return costPrice;
    }
}

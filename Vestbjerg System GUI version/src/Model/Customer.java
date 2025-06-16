package Model;

/**
 * Class respresents customers.
 */
public class Customer {
    private String name;
    private String phone;
    private String email;
    private String address;
    
    /**
     * Constructor for objects of class Customer.
     */
    public Customer(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    /**
     * returns name.
     */
    public String getName() {
        return name;
    }
}

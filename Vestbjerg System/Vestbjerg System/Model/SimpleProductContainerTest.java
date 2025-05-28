package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SimpleProductContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimpleProductContainerTest
{
    /**
     * Default constructor for test class SimpleProductContainerTest
     */
    public SimpleProductContainerTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void TestGetName()
    {
        SimpleProduct product1 = new SimpleProduct(1, "a", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a");
        System.out.println(product1.getName());
    }
    
    @Test
    public void TestfindProductByNameContains()
    {
        SimpleProduct product1 = new SimpleProduct(1, "a", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a");
        SimpleProductContainer.getInstance().addProduct(product1);
        System.out.println(SimpleProductContainer.getInstance().findProductByNameContains("a").size());
    }
}


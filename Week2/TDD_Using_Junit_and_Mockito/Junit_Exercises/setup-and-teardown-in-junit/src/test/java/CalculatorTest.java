import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.example.Calculator;

public class CalculatorTest {
    @Before
    public void setUp() {
        // This method will run before each test
        System.out.println("Setting up before test");
    }
    @After
    public void tearDown() {
        // This method will run after each test
        System.out.println("Tearing down after test");
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }
}

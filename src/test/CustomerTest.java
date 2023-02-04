package test;
import atm.Customer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CustomerTest {
    private Customer customer;
    @Before
    public void setUp() throws Exception {
        customer = new Customer("Shubham","s196",123,300,0);
    }

    @Test
    public  void setCustomer_test(){
        //Assert
        assertEquals("s196",customer.getUserId());
    }

}

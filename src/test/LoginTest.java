package test;

import atm.Customer;
import atm.Login;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private Login login;
    @Before
    public void setUp() throws Exception {
        login = new Login();
    }

    @Test
    public  void loginSuccesfully_test(){
        var customerList= new ArrayList<Customer>();
        customerList.add(new Customer("Shubh","s123",132,300,1));
        login.getAll(customerList);

        var res = login.login("s123",132);
        //Assert
        assertTrue(res);
    }

}

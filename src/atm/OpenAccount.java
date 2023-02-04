/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.ATM.key;
import java.util.*;

/**
 *
 * @author
 */
public class OpenAccount {

    int r = 0;
    private ArrayList<Customer> openAccount;

    public OpenAccount() {
        openAccount = new ArrayList<Customer>();
    }

    public void add() {

        System.out.println("===== Open Account =====");
        System.out.print("Name: ");
        key.nextLine();
        String name = key.nextLine();
        System.out.print("User: ");
        String user = key.nextLine();
        System.out.print("Password: ");
        int pass = key.nextInt();
        System.out.print("Beginning balance: ");
        int bal = key.nextInt();

        openAccount.add(new Customer(name, user, pass, bal, r));
        r++;

    }

    public ArrayList<Customer> getAllCustomer() {
        return openAccount;
    }

    public int siz() {
        return openAccount.size();
    }

}

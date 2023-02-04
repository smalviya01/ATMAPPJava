/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.*;

/**
 *
 * @author
 */
public class Login {

    private ArrayList<Customer> login;
    private int idx = -1;

    public Login() {
        this.login = new ArrayList<Customer>();
    }

    public void getAll(ArrayList<Customer> list) {
        this.login = list;
        this.login = (ArrayList<Customer>) list.clone();
    }

    public boolean login(String user, int pass) {
        boolean log = false;

        for (int i = 0; i < login.size(); i++) {
            Customer n = login.get(i);

            if (user.equals(n.getUserId()) && pass == n.getPassword()) {
                log = true;
                idx = i;
                break;
            } else {
                System.out.println("\n" + "WRONG USERNAME AND PASSWORD!");
                idx = -1;
            }

        }

        return log;
    }

    int getIdxUser() {
        return idx;
    }

    public int getIndex() {
        return idx;
    }
}

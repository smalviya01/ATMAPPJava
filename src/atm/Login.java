/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.*;

/**
 *
 * @author Nade97
 */
public class Login {

    private ArrayList<Nasabah> login;
    private int idx = -1;

    public Login() {
        this.login = new ArrayList<Nasabah>();
    }

    public void getAll(ArrayList<Nasabah> list) {
        this.login = list;
        this.login = (ArrayList<Nasabah>) list.clone();
    }

    public boolean login(String user, int pass) {
        boolean log = false;

        for (int i = 0; i < login.size(); i++) {
            Nasabah n = login.get(i);

            if (user.equals(n.getUser()) && pass == n.getPassword()) {
                log = true;
                idx = i;
                break;
            } else {
                System.out.println("USERNAME DAN PASSWORD SALAH!");
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

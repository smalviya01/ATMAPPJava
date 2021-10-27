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
 * @author Nade97
 */
public class BukaRekening {

    int r = 0;
    private ArrayList<Nasabah> bukaRekening;

    public BukaRekening() {
        bukaRekening = new ArrayList<Nasabah>();
    }

    public void add() {

        System.out.println("===== Buka Rekening =====");
        System.out.print("Nama: ");
        key.nextLine();
        String nama = key.nextLine();
        System.out.print("User: ");
        String user = key.nextLine();
        System.out.print("Password: ");
        int pass = key.nextInt();
        System.out.print("Saldo Awal: ");
        int saldo = key.nextInt();

        bukaRekening.add(new Nasabah(nama, user, pass, saldo, r));
        r++;

    }

    public ArrayList<Nasabah> getAllNasabah() {
        return bukaRekening;
    }

    public int siz() {
        return bukaRekening.size();
    }

}

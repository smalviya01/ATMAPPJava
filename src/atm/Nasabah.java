/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Arrays;

/**
 *
 * @author Nade97
 */
public class Nasabah {

    private String namaLengkap;
    private String User;
    private int Password;
    private int noRek;
    private int Saldo;

// KONSTRUKTOR NASABAH
    public Nasabah(String namaLengkap, String User, int Password, int Saldo, int r) {
        this.namaLengkap = namaLengkap;
        this.User = User;
        this.Password = Password;
        this.noRek = 4444 + r;
        this.Saldo = Saldo;

    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getUser() {

        return User;
    }

    public int getPassword() {
        return Password;
    }

    public int getSaldo() {
        return Saldo;
    }

    public int getNoRek() {
        return noRek;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Nade97
 */
public class Nasabah {
    private String namaLengkap[], User[];
    private int Password[], noRek[];
    private int Saldo[];
    
    // KONSTRUKTOR NASABAH
    public Nasabah(String namaLengkap[], String User[], int Password[], int Saldo[]){
        this.namaLengkap = namaLengkap;
        this.User = User;
        this.Password = Password;
        this.Saldo = Saldo;
    }
    
    
    public void setSaldo(int Saldo[]){
        this.Saldo = Saldo
    }
    
    public String getNamaLengkap(int i){
        return namaLengkap;
    }
    public String getUser(){
        return User;
    }
    public int getPassword(){
        return Password;
    }
    public int getSaldo(){
        return Saldo;
    }
    public int getNoRek(){
        return noRek;
    }

    public String[] getNamaLengkap(){
        return namaLengkap;
    }
}

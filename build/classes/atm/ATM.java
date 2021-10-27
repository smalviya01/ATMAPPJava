/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.util.Scanner;
/**
 *
 * @author Nade97
 */
public class ATM {
    static Scanner keyboard = new Scanner(System.in);
    static Tabungan tabungan;
    static boolean log = false;
    static String Nama;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layanan();
        
        do {
            PilihanLayanan();
        } while (log == true);
        
        
    }
    private static void Layanan(){
        System.out.println("MENU LAYANAN");
        System.out.println("1. Buka Tabungan");
        System.out.println("2. Login");
        
        System.out.print("Pilih Layanan: ");
        int ML = keyboard.nextInt();
        
        switch(ML){
            case 1:
                BukaTabungan();
                break;
            
            case 2:
                login();
                break;
                
            case 3:
                System.out.println("Terima Kasih");
//                System.exit(0);
                break;
            default:
                System.out.println("Input Salah");
                break;
        }
    }
    
    private static void BukaTabungan(){
        System.out.println("");
        System.out.print("Masukan Nama Lengkap: ");
        keyboard.nextLine();
        String nama = keyboard.nextLine();
        
        System.out.print("Masukan User: ");
        String User = keyboard.next();
        System.out.print("Masukan Password: ");
        int pass = keyboard.nextInt();
        System.out.print("Masukan Saldo Awal: ");
        int Saldo = keyboard.nextInt();
        tabungan = new Tabungan(nama, User, pass, Saldo);
        Layanan();
    }
    
    private static void login(){
        System.out.println("Menu Login");
        System.out.print("Masukan User: ");
        String user = keyboard.next();
        System.out.print("Masukan Password: ");
        int password = keyboard.nextInt();
        keyboard.nextLine();
        
        //us = gtus && 
        if (user.equals(tabungan.getUser()) && Integer.toString(password).equals(Integer.toString(tabungan.getPassword()))){
            System.out.println("user password bener");
            log = true;
        } else {
            System.out.println("user password salah");
            Layanan();
        }
    }
    
    private static void PilihanLayanan(){
        System.out.println("SELAMAT DATANG "+ tabungan.getNamaLengkap());
        System.out.println("PILIHAN LAYANAN");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Stor Tunai");
        System.out.println("4. Transfer");
        System.out.println("5. Logout");
        
        System.out.print("Pilih Layanan: ");
        int ML = keyboard.nextInt();
        int jumlah, noRek;
        switch(ML){
            case 1:
                System.out.println("Menu Cek Saldo");
                CekSaldo();
                break;
            
            case 2:
                System.out.println("Menu Tarik Tunai");
                System.out.print("Masukan Nominal Penarikan: ");
                jumlah = keyboard.nextInt();
                tabungan.ambilUang(jumlah);
                PilihanLayanan();
                break;
                
            case 3:
                System.out.println("Menu Stor Tunai");
                System.out.print("Masukan Nominal Stor: ");
                jumlah = keyboard.nextInt();
                tabungan.simpanUang(jumlah);
                PilihanLayanan();
                break;
                
            case 4:
                System.out.println("Menu Transfer");
                System.out.print("Masukan no Rek Tujuan: ");
                noRek = keyboard.nextInt();
                System.out.print("Masukan Nominal Penarikan: ");
                jumlah = keyboard.nextInt();
                tabungan.transfer(jumlah, noRek);
                PilihanLayanan();
                break;
                
            case 5:
                System.out.println("APAKAH INGIN KELUAR DARI APLIKASI? Y/N");
                char exits = (char) keyboard.next().charAt(0);
                if (exits == 'y' || exits == 'Y') {
                    log = false;
                    Layanan();
                }else if (exits == 'n' || exits == 'N') {
                    PilihanLayanan();
                }else{
                    System.out.println("salah input");
                }
                break;
                
            default:
                break;
        }
    }
    
    
    
    private static void CekSaldo(){
        System.out.println("NM: "+tabungan.getNamaLengkap());
        System.out.println("us: "+ tabungan.getUser());
        System.out.println("ps: " +tabungan.getPassword());
        System.out.println("sa: " +tabungan.getSaldo());
    }
}

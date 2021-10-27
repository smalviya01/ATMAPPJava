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
public class ATM {

    static boolean log = false;
    static Scanner key = new Scanner(System.in);
    static BukaRekening br = new BukaRekening();
    static Login login = new Login();
    static Transaksi tr = new Transaksi();

    public static void main(String[] args) {

        int r = 0;
        int pilihan = 0;
        int idx = -1;

        while (true) {
            System.out.println("\t\tSELAMAT DATANG DI MENU LAYANAN");
            System.out.println("\t\t\tBANK PT.MAJU JALAN");
            System.out.println("PILIH LAYANAN");
            System.out.println("1. Buka Rekening");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Masukan Pilihan: ");
            pilihan = key.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("MENU BUKA REKENING");
                    br.add();
                    tr.getAll(br.getAllNasabah());
                    break;

                case 2:
                    login.getAll(br.getAllNasabah());
                    System.out.println("MENU LOGIN");
                    System.out.print("Uername: ");
                    String user = key.next();
                    System.out.print("Password: ");
                    int pass = key.nextInt();

                    log = login.login(user, pass);
                    ;
                    tr.setIdx(login.getIdxUser());

                    while (log == true) {
                        tr.menuTransaksi();
                    }

                    break;

                case 3:
                    System.out.println("Apakah Anda Ingin Keluar? y/n");

                    char exits = (char) key.next().charAt(0);
                    if (exits == 'y' || exits == 'Y') {
                        System.exit(0);
                    } else if (exits == 'n' || exits == 'N') {
                        main(args);
                    } else {
                        System.out.println("Input y/n");
                        pilihan = 3;
                    }
                    break;

                default:
                    System.out.println("SILAHKAN MASUKAN PILIHAN 1 - 3");
                    break;
            }
        }
    }

}

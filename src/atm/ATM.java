/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.*;

/**
 *
 * @author Shubham
 */
public class ATM {

    static boolean log = false;
    static Scanner key = new Scanner(System.in);
    static OpenAccount br = new OpenAccount();
    static Login login = new Login();
    static Transaction tr = new Transaction();

    public static void main(String[] args) {

        int r = 0;
        int option = 0;
        int idx = -1;

        try{
        while (true) {
            System.out.println("\t\tWELCOME TO THE SERVICE MENU");
            System.out.println("\t\t\tBANK Of MANIT");
            System.out.println("SELECT A SERVICE");
            System.out.println("1. Open Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Options: ");
            option = key.nextInt();

            switch (option) {
                case 1:
                    System.out.println("OPEN ACCOUNT MENU");
                    br.add();
                    tr.getAll(br.getAllCustomer());
                    break;

                case 2:
                    login.getAll(br.getAllCustomer());
                    System.out.println("MENU LOGIN");
                    System.out.print("Uername: ");
                    String user = key.next();
                    System.out.print("Password: ");
                    int pass = key.nextInt();

                    log = login.login(user, pass);
                    ;
                    tr.setIdx(login.getIdxUser());

                    while (log == true) {
                        tr.menuTransaction();
                    }

                    break;

                case 3:
                    System.out.println("Do You Want To Quit? y/n");

                    char exits = (char) key.next().charAt(0);
                    if (exits == 'y' || exits == 'Y') {
                        System.exit(0);
                    } else if (exits == 'n' || exits == 'N') {
                        main(args);
                    } else {
                        System.out.println("Input y/n");
                        option = 3;
                    }
                    break;

                default:
                    System.out.println("PLEASE INDICATE YOUR CHOICES 1 - 3");
                    break;
            }
        }}
        catch(Exception ex){
            System.out.println("ATM machine not working.");
        }
    }

}

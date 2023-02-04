package atm;

import java.util.*;

public class Transaction {

    private ArrayList<Customer> transaction;
    Scanner key = new Scanner(System.in);
    private int idx;
    
    

    public void getAll(ArrayList<Customer> list) {
        this.transaction = list;
        this.transaction = (ArrayList<Customer>) list.clone();
    }
    
    public void setIdx(int id){
        idx = id;
    }
    
    public void menuTransaction(){
        Customer n = transaction.get(idx);
        System.out.println("WELCOME "+n.getFullName());
        System.out.println("SERVICE OPTIONS");
        System.out.println("1. Balance check");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Cash Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Logout");
        
        System.out.print("Select Service: ");
        int ML = key.nextInt();
        
        switch(ML){
            case 1:
                checkBalance();
                break;
                
            case 2:
                withdrawCash();
                break;
            
            case 3:
                depositCash();
                break;
                
            case 4:
                transfer();
                break;
                
            case 5:
                System.out.println("DO YOU WANT TO LOGOUT? Y/N");
                
                char exits = (char) key.next().charAt(0);
                if (exits == 'y' || exits == 'Y') {
                    ATM.log = false;
                }else if (exits == 'n' || exits == 'N') {
                    ATM.log = true;
                }else{
                    System.out.println("Input y/n");
                    ML = 5;
                }
                break;
            
        }
        
    }

    private void checkBalance() {
        Customer n = transaction.get(idx);
        System.out.println("Your balance is Rs."+n.getBalance());
    }

    private void withdrawCash() {
        Customer n = transaction.get(idx);
        System.out.print("Enter the Withdrawal Amount: ");
        int nom = key.nextInt();
        
        if (n.getBalance() >= nom) {
            int bal = n.getBalance() - nom;
            n.setBalance(bal);
            System.out.println("Withdraw Rs."+ nom + " Succeeded");
        }else{
            System.out.println("Your Balance Is Insufficient");
        }
    }

    private void depositCash() {
        Customer n = transaction.get(idx);
        int bal = n.getBalance();
        System.out.print("\n" + "Enter the Amount:");
        int nom = key.nextInt();
        
        bal = bal + nom;
        n.setBalance(bal);
        System.out.println("Cash Deposit Rs." + nom + " succeeded");
        
    }

    private void transfer() {
        Customer n = transaction.get(idx);
        System.out.print("\n" +  "Enter Destination Account Number: ");
        int Accno = key.nextInt();
        System.out.print("Enter transfer Amount: ");
        int nom = key.nextInt();
        
        
        for (int i = 0; i < this.transaction.size(); i++) {
            Customer na = transaction.get(i);
            
            if (na.getAccountNo() == Accno) {
                if (n.getBalance() >= nom) {
                    n.setBalance(n.getBalance()-nom);
                    na.setBalance(na.getBalance()+nom);
                    
                    System.out.println("Transfer Rs."+nom);
                    System.out.println("Destination Account No: "+Accno);
                    System.out.println("Succeeded!");
                    break;
                }else{
                    System.out.println("Your Balance Is Insufficient");
                    break;
                }
            }else if (i == this.transaction.size()) {
                System.out.println("\n" +  "Wrong Account No");
                break;
            }
        }
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author
 */
public class Customer {

    private String FullName;
    private String UserId;
    private int Password;
    private int AccountNo;
    private int Balance;

    public Customer(String fullname, String User, int Password, int bal, int r) {
        this.FullName = fullname;
        this.UserId = User;
        this.Password = Password;
        this.AccountNo = 4444 + r;
        this.Balance = bal;

    }

    public void setBalance(int bal) {
        this.Balance = bal;
    }

    public String getFullName() {
        return FullName;
    }

    public String getUserId() {

        return UserId;
    }

    public int getPassword() {
        return Password;
    }

    public int getBalance() {
        return Balance;
    }

    public int getAccountNo() {
        return AccountNo;
    }

}

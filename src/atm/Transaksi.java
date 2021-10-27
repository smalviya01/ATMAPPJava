package atm;

import java.util.*;

public class Transaksi {

    private ArrayList<Nasabah> trasaksi;
    Scanner key = new Scanner(System.in);
    private int idx;
    
    

    public void getAll(ArrayList<Nasabah> list) {
        this.trasaksi = list;
        this.trasaksi = (ArrayList<Nasabah>) list.clone();
    }
    
    public void setIdx(int id){
        idx = id;
    }
    
    public void menuTransaksi(){
        Nasabah n = trasaksi.get(idx);
        System.out.println("SELAMAT DATANG "+n.getNamaLengkap());
        System.out.println("PILIHAN LAYANAN");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Stor Tunai");
        System.out.println("4. Transfer");
        System.out.println("5. Logout");
        
        System.out.print("Pilih Layanan: ");
        int ML = key.nextInt();
        
        switch(ML){
            case 1:
                cekSaldo();
                break;
                
            case 2:
                tarikTunai();
                break;
            
            case 3:
                storTunai();
                break;
                
            case 4:
                transfer();
                break;
                
            case 5:
                System.out.println("APAKAH INGIN LOGOUT? Y/N");
                
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

    private void cekSaldo() {
        Nasabah n = trasaksi.get(idx);
        System.out.println("Saldo Anda Rp."+n.getSaldo());
    }

    private void tarikTunai() {
        Nasabah n = trasaksi.get(idx);
        System.out.print("Masukan Nominal Penarikan: ");
        int nom = key.nextInt();
        
        if (n.getSaldo() >= nom) {
            int saldo = n.getSaldo() - nom;
            n.setSaldo(saldo);
            System.out.println("Prnarikan Rp."+ nom + " Berhasil");
        }else{
            System.out.println("Saldo Anda Tidak Cukup");
        }
    }

    private void storTunai() {
        Nasabah n = trasaksi.get(idx);
        int saldo = n.getSaldo();
        System.out.print("Masukan Nominal Stor:");
        int nom = key.nextInt();
        
        saldo = saldo + nom;
        n.setSaldo(saldo);
        System.out.println("Stor Tunai Rp." + nom + " Berhasil");
        
    }

    private void transfer() {
        Nasabah n = trasaksi.get(idx);
        System.out.print("Masukan No Rek Tujuan: ");
        int norek = key.nextInt();
        System.out.print("Masukan Nominal Transfer: ");
        int nom = key.nextInt();
        
        
        for (int i = 0; i < this.trasaksi.size(); i++) {
            Nasabah na = trasaksi.get(i);
            
            if (na.getNoRek() == norek) {
                if (n.getSaldo() >= nom) {
                    n.setSaldo(n.getSaldo()-nom);
                    na.setSaldo(na.getSaldo()+nom);
                    
                    System.out.println("Transfer Rp."+nom);
                    System.out.println("No Rek Tujuan: "+norek);
                    System.out.println("Berhasil!");
                    break;
                }else{
                    System.out.println("Saldo Anda Tidak Cukup");
                    break;
                }
            }else if (i == this.trasaksi.size()) {
                System.out.println("No Rek Salah");
                break;
            }
        }
    }
    
    

}

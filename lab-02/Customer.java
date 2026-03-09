import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Customer {
    private double wallet;
    
    public Customer() {
        wallet = 500.00;
    }
    
    public Customer(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        wallet = scanner.nextDouble();
        scanner.close();
    }
    
    public double spend(double amount) {
        if (amount > wallet) {
            double remaining = wallet;
            wallet = 0;
            return remaining;
        } else {
            wallet -= amount;
            return amount;
        }
    }
    
    public void receive(double amount) {
        wallet += amount;
    }
    
    public double checkWallet() {
        return wallet;
    }
    
    public void save(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.println(wallet);
        writer.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    private char reel1;
    private char reel2;
    private char reel3;
    private double moneyPot;
    
    public SlotMachine() {
        moneyPot = 1000000.00;
    }
    
    public String toString(){
        return "Reel 1: " + reel1 + ", Reel 2: " + reel2 + ", Reel 3: " + reel3;
    }
    
    public double getMoneyPot(){
        return moneyPot;
    }
    
    public SlotMachine(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        moneyPot = scanner.nextDouble();
        scanner.close();
    }
    
    public void save(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.println(moneyPot);
        writer.close();
    }

    public double pullLever(double amount) {
        Random rand = new Random();
        
        // Set reel1
        int randomNumber = rand.nextInt(3);
        char symbol;
        if (randomNumber == 0) {
            symbol = '☺';
        } else if (randomNumber == 1) {
            symbol = '❤';
        } else {
            symbol = '7';
        }
        reel1 = symbol;
        
        // Set reel2
        randomNumber = rand.nextInt(3);
        if (randomNumber == 0) {
            symbol = '☺';
        } else if (randomNumber == 1) {
            symbol = '❤';
        } else {
            symbol = '7';
        }
        reel2 = symbol;
        
        // Set reel3
        randomNumber = rand.nextInt(3);
        if (randomNumber == 0) {
            symbol = '☺';
        } else if (randomNumber == 1) {
            symbol = '❤';
        } else {
            symbol = '7';
        }
        reel3 = symbol;
        
        // Check if all 3 match
        if (reel1 == reel2 && reel2 == reel3) {
            double winnings = amount * 10;
            moneyPot -= winnings;
            return winnings;
        } else {
            return 0;
        }
    }
}
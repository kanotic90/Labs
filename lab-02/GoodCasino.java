import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoodCasino {
    
    public static double play(Customer customer, SlotMachine machine, double amount) {
        double spent = customer.spend(amount);
        double winnings = machine.pullLever(spent);
        return winnings;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Customer customer = new Customer("customer.txt");
        SlotMachine machine = new SlotMachine("slot-machine.txt");
        
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        
        while (playing) {
            System.out.print("How much would you like to bet? (or type 'quit'): ");
            String input = scanner.nextLine();
            
            if (input.equals("quit")) {
                playing = false;
            } else {
                double bet = Double.parseDouble(input);
                
                if (bet > customer.checkWallet()) {
                    System.out.println("You don't have that much money!");
                    continue;
                }
                
                double winnings = play(customer, machine, bet);
                
                System.out.println(machine.toString());
                System.out.println("You won: $" + winnings);
                
                customer.receive(winnings);

                System.out.println("Your wallet: $" + customer.checkWallet());
                System.out.println("Casino has: $" + machine.getMoneyPot());
                System.out.println();
                
                if (customer.checkWallet() <= 0) {
                    System.out.println("You're out of money!");
                    playing = false;
                } else if (machine.getMoneyPot() <= 0) {
                    System.out.println("Casino is out of money!");
                    playing = false;
                }
            }
        }
        
        customer.save("customer.txt");
        machine.save("slot-machine.txt");
        System.out.println("Game saved!");
    }
}
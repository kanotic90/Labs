import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter hexidecimal");
        String hex = input.nextLine();

        int decimal = 0;

        for (int i = 0; i < hex.length(); i++) {

            char ch = hex.charAt(i);
            int value = 0;

            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            }
            else if (ch >= 'A' && ch <= 'F') {
                value = ch - 'A' + 10;
            }
            else if (ch >= 'a' && ch <= 'f') {
                value = ch - 'a' + 10;
            }
            else {
       
                System.err.println("Error: Invalid hexadecimal number.");
                
                System.exit(1);
            }

            decimal = decimal * 16 + value;
        }

        System.out.println("Decimal value: " + decimal);

        input.close();
    }
}
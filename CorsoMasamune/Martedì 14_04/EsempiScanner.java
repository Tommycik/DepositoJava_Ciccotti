import java.util.Scanner;
public class EsempiScanner {
    public static void main(String[] args) {
        // Scanner per string input
        Scanner scanner = new Scanner(System.in);// Create a scanner object to read input from the user
        System.out.println("Enter username:");
        // Read user input
        String username = scanner.nextLine(); // Read a line of text from the user
        // Output user input 
        System.out.println("Hello, " + username + "!"); // Greet the user with
        
        // Scanner per integer input
        Scanner intScanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        // Read user input
        int numero = intScanner.nextInt();
        // Output user input 
        System.out.println("You entered: " + numero);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioBank {
    
    public static void main(String[] args) {   
        //Accounts 
        ArrayList<BankAccount> accounts = new ArrayList<>();
        //Scanners
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        boolean continueLoop = true;
        //while loop
        while(continueLoop){
            String username;
            BankAccount account = null;
            String password;
            boolean isValid = false;
            while (!isValid) {
                //Menu di login e register
                System.out.println("Welcome to the Banking System");
                System.out.println("1. Login");
                System.out.println("2. Register");
                // inserisci usrname e password
                int choice = intScanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Enter your username:");
                        username = stringScanner.nextLine();
                        System.out.println("Enter your password:");
                        password = stringScanner.nextLine();
                        //controllo che l'account esista
                        for (BankAccount bankAccount : accounts) {
                            boolean valid= bankAccount.login(username, password);
                            if (valid) {
                                isValid = true;
                                account = bankAccount;
                                break;
                            }

                        };
                        if(!isValid){
                            System.out.println("Invalid login credentials");
                        }
                        break;
                    case 2:
                        System.out.println("Enter your username:");
                        username = stringScanner.nextLine();
                        System.out.println("Enter your password:");
                        password = stringScanner.nextLine();
                        boolean anotherName = false;
                        //controlla non ci siano già account con questo username
                        for (BankAccount account2 : accounts) {
                            if (account2.getHolderName().equals(username)) {
                                System.out.println("Username already exists");
                                anotherName = true;
                                break;
                            }
                        }
                        // inserisci account
                        if(!anotherName){
                            account= new BankAccount(username, 0, password);
                            accounts.add(account);
                            System.out.println("Account created");
                            isValid = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
            }
            boolean operate = true;
            if(account == null){
                System.out.println("Invalid account");
                continue;
            }
            while(operate){
                //Menu di deposito, prelievo , saldo e cambio account
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                System.out.println("4. Change account");
                System.out.println("4. Exit");
                int choice = Integer.parseInt(stringScanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount to deposit:");
                        double amount = doubleScanner.nextDouble();
                        account.deposit(amount);
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw:");
                        double amount2 = doubleScanner.nextDouble();
                        account.withdraw(amount2);
                        break;
                    case 3:
                        account.displayBalance();
                        break;
                    case 4:
                        operate = false;
                        break;
                    case 5:
                        operate = false;
                        continueLoop = false;
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
            
            }
        }
    }
}
class BankAccount {
    private String holderName;
    private double balance;
    private String password;
    
    // Costruttore
    public BankAccount(String holderName, double balance, String password) {
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
    }
    //Getter
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    //login
    public boolean login(String name, String password) {
        //controllo che il nome e la password siano corretti
        if (name.equals(holderName) && password.equals(this.password)) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Invalid login credentials");
            return false;
        }
    }
    //deposit
    public void deposit(double amount) {
        balance += amount;
    }

    //withdraw
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    // displayBalance
    public void displayBalance() {
        System.out.println("Account balance: " + balance+ " $");
    }

    //override toString
    @Override
    public String toString() {
        return "Account holder: " + holderName + "\n" + "Account balance: " + balance + " $";
    }
    //override equals
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        }
        if (o instanceof BankAccount) {
            BankAccount account = (BankAccount) o;
            return holderName.equals(account.holderName) && balance == account.balance;
        }
        return false;
    }
    //override hashCode
    @Override
    public int hashCode() {
        int result = holderName.hashCode();
        result = 31 * result + (int) (balance * 31);
        return result;
    }

}

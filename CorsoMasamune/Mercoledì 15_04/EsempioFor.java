import java.util.Scanner;

public class EsempioFor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Richiede numero
        System.out.println("Inserisci un numero: ");
        int numero = scanner.nextInt();
        //Stampa la tabellina
        System.out.println("Tabelina del " + numero + ":");
        // Ciclo for per moltiplicare il numero da 1 a 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " * " + i + " = " + i * numero);
        }
        scanner.close();

    }
}

import java.util.Scanner;

public class EsempioWhile {
    public static void main(String[] args) {

        int i = 1; // Inizializzazione della variabile di controllo
        while (i <= 5) {
            i++; // Incremento della variabile di controllo
            System.out.println(i);
        }
        // Scanner per input
        Scanner input = new Scanner(System.in);
        int numero;
        // Ciclo do-while per inserire numeri finché non viene inserito 0
        do {
            System.out.print("Inserisci un numero (0 per uscire): ");
            numero = input.nextInt();
        } while (numero != 0);
        //Uscita dal ciclo quando viene inserito 0
        System.out.println("Hai inserito 0. Programma terminato.");
    }
}

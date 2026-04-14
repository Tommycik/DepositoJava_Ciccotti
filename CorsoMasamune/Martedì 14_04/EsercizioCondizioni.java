import java.util.Scanner;

public class EsercizioCondizioni {
    public static void main(String[] args) {
        // Dichiarazione variabili
        int età;
        boolean hasTicket;
        boolean accompaniedByAdult;
        boolean skipWaitingLine;
        // Scanners per input
        Scanner booleanScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        // Input età
        System.out.println("Inserisci la tua età:");
        // Lettura input età
        età = intScanner.nextInt();
        // Output età
        System.out.println("La tua età è: " + età);

        // Input se ha il biglietto
        System.out.println("Hai un biglietto? (true/false)");
        // Lettura input biglietto
        hasTicket = booleanScanner.nextBoolean();
        // Output biglietto
        System.out.println("Hai un biglietto: " + hasTicket);
        
        // Input se è accompagnato da un adulto
        System.out.println("Sei accompagnato da un adulto? (true/false)");
        // Lettura input accompagnamento
        accompaniedByAdult = booleanScanner.nextBoolean();
        // Output accompagnamento
        System.out.println("Sei accompagnato da un adulto: " + accompaniedByAdult);
        
        // Input se salta fila
        System.out.println("Hai il salta fila? (true/false)");
        // Lettura input salto fila
        skipWaitingLine = booleanScanner.nextBoolean();
        // Output salta fila
        System.out.println("Hai il salta fila: " + skipWaitingLine);
        
        // Condizioni per l'ingresso
        if(hasTicket){
            System.out.println("Puoi entrare!");
        } else {
            System.out.println("Non puoi entrare senza un biglietto.");
        }

        if(accompaniedByAdult){
            System.out.println("Sei accompaganto da un adulto, puoi entrare anche senza biglietto!");
        } else {
            System.out.println("Sei da solo.");
        }

        if(skipWaitingLine){
            System.out.println("Hai il salta fila, puoi entrare senza aspettare!");
        } else {
            System.out.println("Non hai il salta fila, dovrai aspettare in coda.");
        }
    }
}

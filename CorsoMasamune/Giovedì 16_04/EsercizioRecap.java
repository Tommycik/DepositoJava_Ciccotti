
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioRecap {
    // Funzione per calcolare la media di una lista di numeri interi  
    public static int calcolaMedia(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
           System.out.println("La lista è vuota. Impossibile calcolare la media.");
           return 0; // Evita la divisione per zero
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
    // Funzione per trovare il numero massimo in una lista di numeri interi
    public static int trovaMax(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("La lista è vuota. Impossibile trovare il massimo.");
            return 0; // Restituisce il valore minimo possibile
        }
        int max = Collections.max(numbers);
        return max;
    }
    // Funzione per trovare il numero minimo in una lista di numeri interi
    public static int trovaMin(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("La lista è vuota. Impossibile trovare il minimo.");
            return 0; // Restituisce il valore massimo possibile
        }
        int min = Collections.min(numbers);
        return min;
    }
    // Funzione per verificare se lo studente è promosso o bocciato in base alla media dei voti
    public static String verificaPromozione(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            return "La lista dei voti è vuota. Impossibile verificare la promozione.";
        }
        int average = calcolaMedia(grades);
        if (average >= 6) {
            return "Promosso";
        } else {
            return "Bocciato";
        }
    }

    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int numberOfGrades = 0;
        do{
            // Chiede all'utente quanti voti vuole inserire
            System.out.println("Quanti voti vuoi inserire?");
            numberOfGrades = intScanner.nextInt();
            if(numberOfGrades < 0){
                System.out.println("Il numero di voti deve essere maggiore o uguale a zero. Riprova.");
                continue; // Torna all'inizio del ciclo
            }else{
                break; // Esce dal ciclo se il numero di voti è valido
            }
        }while(true);

        for(int i = 0; i < numberOfGrades; i++){
            System.out.println("Inserisci il voto " + (i + 1) + ":");
            int grade = intScanner.nextInt();
            if(grade < 0 || grade > 10){
                System.out.println("Il voto deve essere compreso tra 0 e 10. Riprova.");
                i--; // Decrementa i per permettere di inserire nuovamente il voto
            }else{
                grades.add(grade);
            }
        }
        // Menu per scegliere quale operazione eseguire sui voti inseriti
        boolean exit = false;
        while(!exit){
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Calcola la media");
            System.out.println("2. Trova il massimo");
            System.out.println("3. Trova il minimo");
            System.out.println("4. Verifica promozione");
            System.out.println("5. Esci");
            int choice = intScanner.nextInt();
            // Esegui l'azione corrispondente alla scelta dell'utente
            switch (choice) {
                case 1:
                    System.out.println("La media dei voti è: " + calcolaMedia(grades));
                    break;
                case 2:
                    System.out.println("Il voto massimo è: " + trovaMax(grades));
                    break;
                case 3:
                    System.out.println("Il voto minimo è: " + trovaMin(grades));
                    break;
                case 4:
                    System.out.println(verificaPromozione(grades));
                    break;
                case 5:
                    System.out.println("Uscita dal programma.");
                    exit = true;
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
    }
}

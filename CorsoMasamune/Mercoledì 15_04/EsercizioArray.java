import java.util.Scanner;
public class EsercizioArray {
    public static void main(String[] args) {
        // Array per memorizzare i dolci ordinati e le quantità
        String[] dolciOrdinati;
        int[]quantitàDolci;
        // Array predefinito di dolci e prezzi
        String[] dolci={"Torta", "Biscotti", "Cioccolatini", "Caramelle", "Gelato", "Pasticcini", "Croissant", "Muffin", "Cupcake", "Donut", "Tiramisu", "Cheesecake"};
        int[] prezzi={20, 10, 15, 5, 25, 30, 12, 18, 22, 8, 28, 26};
        // Limite massimo di dolci ordinabili
        final int maxDolci = 10;
        // Variabile per tenere traccia del numero totale di dolci ordinati
        int dolciPresi = 0;
        // Scanner per input
        Scanner scannerString = new java.util.Scanner(System.in);
        Scanner scannerInt = new java.util.Scanner(System.in);
        // Chiede all'utente quanti dolci diversi vuole ordinare
        System.out.println("Quanti dolci diversi vuoi inserire?");
        int numeroDolci = scannerInt.nextInt();
        // Controlla se il numero di dolci è positivo e non maggiore di 10
        while(numeroDolci<=0 || numeroDolci>10) {
            if(numeroDolci<=0) {
                System.out.println("Numero di dolci minore o uguale a zero. Riprova.");
            } else {
                System.out.println("Numero di dolci maggiore di 10. Riprova.");
            }
            numeroDolci = scannerInt.nextInt();
        }
        // Inizializza gli array per i dolci ordinati e le quantità
        dolciOrdinati = new String[numeroDolci];
        quantitàDolci = new int[numeroDolci];
        // Stampa il menu dei dolci con i prezzi
        System.out.println("Menu dei dolci:");
            for(int j=0; j<dolci.length; j++) {
                System.out.println((j+1) + ". " + dolci[j] + " - prezzo: " + prezzi[j]);
            }
        // Ciclo per la scelta dei dolci e delle quantità
        for(int i=0; i<numeroDolci; i++) {
            // Controlla se il numero totale di dolci ordinati ha raggiunto il limite massimo
            if(dolciPresi >= maxDolci) {
                System.out.println("Hai raggiunto il limite massimo di dolci ordinabili (" + maxDolci + ").");
                break;
            }
            int indiceDolce = -1;
            //Scelta del dolce
            do{
            System.out.println("Scegli il dolce da ordinare : ");
            String sceltaDolceString = scannerString.nextLine();
            // Controllo se la stringa esiste nell'array dei dolci
            
            for(int j=0; j<dolci.length; j++) {
                // Trova l'indice del dolce scelto
                if(sceltaDolceString.equalsIgnoreCase(dolci[j])) {
                    indiceDolce = j;
                    break;
                }
                if((indiceDolce == -1 && j == dolci.length-1)) {
                    System.out.println("Scelta del dolce non valida. Riprova.");
                }
            }
            }while(indiceDolce==-1);
            dolciOrdinati[i] = dolci[indiceDolce];
            //Scelta della quantità
            System.out.println("Quanti " + dolci[indiceDolce] + " vuoi ordinare?");
            int quantità = scannerInt.nextInt();
            // Controlla se la quantità è positiva e non supera il limite disponibile
            while(quantità<=0 || quantità>(maxDolci-dolciPresi)) {
                if (quantità <=0) {
                    System.out.println("Quantità minore o uguale a zero. Riprova.");
                } else {
                    System.out.println("Quantità maggiore del limite disponibile. Riprova.");
                }
                quantità = scannerInt.nextInt();
            }
            quantitàDolci[i] = quantità;
            dolciPresi += quantità;
        }
        System.out.println("Riepilogo dell'ordine:");
        //Totale dolci ordinati
        int totaleDolci = 0;
        for(int i=0; i<numeroDolci; i++) {
            if(dolciOrdinati[i] != null) {
                System.out.println(quantitàDolci[i] + " x " + dolciOrdinati[i]);
                totaleDolci += quantitàDolci[i];
            }
        }
        System.out.println("Totale dolci ordinati: " + totaleDolci);
        //Calcolo del costo totale
        int costoTotale = 0;
        for(int i=0; i<numeroDolci; i++) {
            int indiceDolce = 0;
            for(int j=0; j<dolci.length; j++) {
                if(dolciOrdinati[i] != null && dolciOrdinati[i].equalsIgnoreCase(dolci[j])) {
                    indiceDolce = j;
                    break;
                }
            }
            costoTotale += quantitàDolci[i] * prezzi[indiceDolce];
        }
        System.out.println("Costo totale dell'ordine: " + costoTotale);
    }
}

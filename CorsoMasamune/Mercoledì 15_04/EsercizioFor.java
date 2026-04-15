public class EsercizioFor {
    public static void main(String[] args) {
        int numeroVoti;
        int validi;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while(true) {
            // Chiede all'utente quanti voti vuole inserire
            System.out.println("Quanti voti vuoi inserire?");
            numeroVoti = scanner.nextInt();
            validi = 0;
            // Controlla se il numero di voti è positivo
            while(numeroVoti<=0) {
                System.out.println("Numero di voti minore o uguale a zero. Riprova.");
                numeroVoti = scanner.nextInt();
            }
            // Ciclo per inserire i voti
            for(int i = 0; i < numeroVoti; i++) {
                // Chiede all'utente di inserire il voto
                System.out.println("Inserisci un voto tra 0 e 30:");
                int voto = scanner.nextInt();
                // Selezione risposta in base al voto inserito
                if(voto < 0 || voto > 30) {
                    System.out.println("Voto non valido. Riprova.");
                } else {
                    validi++;
                    if(voto >= 18 && voto < 24){
                        System.out.println("Voto sufficiente.");
                    } else if(voto >= 24) {
                        System.out.println("Voto buono o ottimo.");
                    } else {
                        System.out.println("Voto insufficiente.");
                    }   
                }
            }
            // Stampa il numero di voti validi inseriti
            System.out.println("Hai inserito " + validi + " voti validi.");
            // Chiede all'utente se vuole inserire altri voti
            System.out.println("Vuoi inserire altri voti? (s/n)");
            String risposta = scanner.next();
            if(risposta.equalsIgnoreCase("n")) {
                System.out.println("Programma terminato.");
                break; // Esce dal ciclo while se l'utente non vuole inserire altri voti
            }
        }
    }
}

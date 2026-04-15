public class EsercizioFor {
    public static void main(String[] args) {
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while(true) {
            // Chide all'utente quanti voti vuole inserire
            System.out.println("Quanti voti vuoi inserire?");
            int numeroVoti = scanner.nextInt();
            int validi = 0;
            while(numeroVoti>0) {
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
                            System.out.println("Voto ottimo.");
                        } else {
                            System.out.println("Voto insufficiente.");
                        }   
                    }
                }
            }
        System.out.println("Hai inserito " + validi + " voti validi.");
        }
    }
}

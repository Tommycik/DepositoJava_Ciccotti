import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class EserciziArrayList {
    public static void main(String[] args) {
        ArrayList<String> nomi_O = new ArrayList<>();
        Scanner scannerString = new Scanner(System.in);

        boolean continua = true;
        //Ciclo principale per gestire l'inserimento dei nomi e le operazioni sulla lista
        while(continua){
            //Chiedi all'utente di inserire un nome o di digitare "fine" per terminare
            while(true){
                System.out.println("Inserisci un nome (o 'fine' per terminare): ");
                String nome_O = scannerString.nextLine();
                if(nome_O.equalsIgnoreCase("fine")){
                    break;
                }
                nomi_O.add(nome_O.toLowerCase());
            }
            System.out.println("Lista dei nomi: " + nomi_O);
            while(true){
                //Chiedi se l'utente vuole stampare in oldine alfabetico,il numero degli studenti o eliminare qualcuno
                System.out.println("Vuoi stampare in ordine alfabetico (a), il numero degli studenti (n), eliminare qualcuno (e)?");
                String scelta = scannerString.nextLine();
                if(scelta.equalsIgnoreCase("a")){
                    Collections.sort(nomi_O);
                    System.out.println("Lista dei nomi in ordine alfabetico: " + nomi_O);
                }else if(scelta.equalsIgnoreCase("n")){
                    System.out.println("Numero degli studenti: " + nomi_O.size());
                }else if(scelta.equalsIgnoreCase("e")){
                    //Stampa la lista dei nomi
                    System.out.println("Lista dei nomi: " + nomi_O);
                    System.out.println("Inserisci il nome dello studente da eliminare:");
                    String nomeDaEliminare = scannerString.nextLine().toLowerCase();
                    //Rimuove il nome dalla lista e stampa un messaggio di conferma o di errore
                    if(nomi_O.remove(nomeDaEliminare)){
                        System.out.println("Studente eliminato.");
                    }else{
                        System.out.println("Studente non trovato.");
                    }
                }else{
                    System.out.println("Scelta non valida.");
                }
                //Chiedere se vuole aggiungere un altro nome o terminare o continuare a fare operazioni
                System.out.println("Vuoi aggiungere un altro nome (a), terminare (t) o continuare a fare operazioni (qualsiasi altro)?");
                String scelta2 = scannerString.nextLine();
                if(scelta2.equalsIgnoreCase("a")){
                    break;
                }else if(scelta2.equalsIgnoreCase("t")){
                    continua = false;
                    break;
                }
            }

        }
    }
}

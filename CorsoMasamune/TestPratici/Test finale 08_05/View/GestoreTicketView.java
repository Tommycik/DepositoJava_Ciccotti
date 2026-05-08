
import java.util.ArrayList;
//View Gestore ticket
public class GestoreTicketView {
    //menu utenti normali
    public static void menuUtentiNormale() {
        System.out.println("Menu utenti:");
        System.out.println("1. Aggiungi ticket");
        System.out.println("2. Lista ticket");
        System.out.println("3. Cerca ticket per titolo");
        System.out.println("4. Logout");
        System.out.println("5. Esci");

    }
    //menu utenti admin
    public static void menuUtentiAdmin() {
        System.out.println("Menu admin:");
        System.out.println("1. Lista ticket");
        System.out.println("2. Risolvi ticket");
        System.out.println("3. Elimina ticket");
        System.out.println("4. Cerca ticket per titolo");
        System.out.println("5. Logout");
        System.out.println("6. Esci");
    }
    //menu utenti non loggati
    public static void menuUtentiNonLoggato() {
        System.out.println("Menu utenti non loggati:");
        System.out.println("1. Login");
        System.out.println("2. Esci");
    }
    //Stampa lista ticket
    public static void stampaListaTicket(ArrayList<Ticket> tickets) {
        for(Ticket ticket : tickets) {
            System.out.println(ticket.descrizioneCompleta());
        }
    }
    //stampa messagio
    public static void stampaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
    //Stampa notifiche
    public static void stampaNotifiche(ArrayList<String> notifiche) {
        for(String notifica : notifiche) {
            System.out.println(notifica);
        }
        System.out.println();
    }
    
}

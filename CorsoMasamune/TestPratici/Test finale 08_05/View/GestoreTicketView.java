package View;

import java.util.ArrayList;
import Model.Ticket;
//View Gestore ticket
public class GestoreTicketView {
    //menu utenti normali
    public void menuUtentiNormale() {
        System.out.println("Menu utenti:");
        System.out.println("1. Aggiungi ticket");
        System.out.println("2. Lista ticket");
        System.out.println("3. Cerca ticket per titolo");
        System.out.println("4. Guarda notifiche");
        System.out.println("5. Logout");
        System.out.println("6. Esci\n");

    }
    //menu utenti admin
    public void menuUtentiAdmin() {
        System.out.println("Menu admin:");
        System.out.println("1. Lista ticket");
        System.out.println("2. Risolvi ticket");
        System.out.println("3. Elimina ticket");
        System.out.println("4. Modifica ticket");
        System.out.println("5. Cerca ticket per titolo");
        System.out.println("6. Guarda notifiche");
        System.out.println("7. Logout");
        System.out.println("8. Esci\n");
    }
    //menu utenti non loggati
    public void menuUtentiNonLoggato() {
        System.out.println("Menu utenti non loggati:");
        System.out.println("1. Login");
        System.out.println("2. Registrati");
        System.out.println("3. Esci\n");
    }
    //Stampa lista ticket
    public void stampaListaTicket(ArrayList<Ticket> tickets) {
        if(tickets.size() == 0) {
            System.out.println("Non ci sono ticket");
        }else {
            for(Ticket ticket : tickets) {
                System.out.println(ticket.getDescrizioneCompleta());
            }
        }
        System.out.println("\n");
    }
    //stampa messagio
    public void stampaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
    //Stampa notifiche
    public void stampaNotifiche(ArrayList<String> notifiche) {
        if(notifiche.size() == 0) {
            System.out.println("Non ci sono notifiche");
        }else {
            for(String notifica : notifiche) {
                System.out.println(notifica);
            }
        }
        System.out.println("\n");
    }
    
}

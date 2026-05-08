package Controller;

import java.util.Scanner;
//classe astratta per startegia menu utente loggato
public abstract class StrategyMenuUtente  implements StrategyMenu{
    //metodo helper logout
    protected void logout(GestoreTicketController controller) {
        //logout
        if(controller.getSessione().logout()) {
            controller.getView().stampaMessaggio("Logout effettuato con successo");
        }else {
            controller.getView().stampaMessaggio("Logout non effettuato");
        }
    }
    //metodo helper visualizzare notifiche
    protected void visualizzaNotifiche(GestoreTicketController controller) {
        Scanner stringScanner = new Scanner(System.in);
        //visualizza notifiche
        controller.getView().stampaNotifiche(controller.getSessione().getNotifiche());
        //chiedi se vuole cancellare notifiche
        controller.getView().stampaMessaggio("Vuoi cancellare le notifiche?(s/n)");
        if(stringScanner.nextLine().equalsIgnoreCase("s")) {
            controller.getSessione().cancellaNotifiche();
            controller.getView().stampaMessaggio("Notifiche cancellate");
        }else if(stringScanner.nextLine().equalsIgnoreCase("n")) {
            controller.getView().stampaMessaggio("Notifiche non cancellate");
        }else {
            controller.getView().stampaMessaggio("Comando non valido");
        }
    }
    //metodo helper per cercare ticket per titolo
    protected void cercaTicket(GestoreTicketController controller) {
        Scanner stringScanner = new Scanner(System.in);
        //cerca ticket per titolo
        controller.getView().stampaMessaggio("Inserisci il titolo del ticket da cercare:");
        String titolo = stringScanner.nextLine();
        //cerca ticket
        if(controller.getGestore().cercaTicket(titolo) != null) {
            controller.getView().stampaMessaggio(controller.getGestore().cercaTicket(titolo).getDescrizioneCompleta());
        }else {
            controller.getView().stampaMessaggio("Ticket non trovato");
        }
    }
    
}

package Controller;

import java.util.Scanner;
import View.GestoreTicketView;
import Model.Ticket;
//classe strategia concretautente
public class StrategyUtente implements StrategyMenu{
    //metodo stampaMenu
    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiNormale();
    }

    //metodo eseguiAzioneMenu
    @Override
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        Scanner stringScanner = new Scanner(System.in);
        //controllo scelta
        switch(scelta) {
            case 1:
                //aggiungi ticket
                controller.getView().stampaMessaggio("Inserisci titolo del ticket:");
                String titolo = stringScanner.nextLine();
                controller.getView().stampaMessaggio("Inserisci autore del ticket:");
                String autore = stringScanner.nextLine();
                controller.getView().stampaMessaggio("Inserisci descrizione del ticket:");
                String descrizione = stringScanner.nextLine();
                controller.getView().stampaMessaggio(controller.getGestore().addTicket(new Ticket(titolo, autore, descrizione)));
                break;
            case 2:
                //lista ticket
                controller.getView().stampaListaTicket(controller.getGestore().getTickets());
                break;
            case 3:
                //cerca ticket per titolo
                controller.getView().stampaMessaggio("Inserisci titolo del ticket da cercare:");
                String titolo2 = stringScanner.nextLine();
                Ticket ticket = controller.getGestore().searchTicket(titolo2);
                //stampa ticket
                if(ticket != null) {
                    controller.getView().stampaMessaggio(ticket.getDescrizioneCompleta());
                }else {
                    controller.getView().stampaMessaggio("Ticket non trovato");
                }
                break;
            case 4: 
                //guarda notifiche
                controller.getView().stampaNotifiche(controller.getGestore().getUtente().getNotifiche());
                //chiedi se vuole cancellare notifiche
                controller.getView().stampaMessaggio("Vuoi cancellare le notifiche?(s/n)");
                if(stringScanner.nextLine().equalsIgnoreCase("s")) {
                    controller.getGestore().getUtente().cancellaNotifiche();
                    controller.getView().stampaMessaggio("Notifiche cancellate");
                }else if(stringScanner.nextLine().equalsIgnoreCase("n")) {
                    controller.getView().stampaMessaggio("Notifiche non cancellate");
                }else {
                    controller.getView().stampaMessaggio("Comando non valido");
                }
                break;
            case 5:
                //logout
                if(controller.getGestore().logout()) {
                    controller.getView().stampaMessaggio("Logout effettuato con successo");
                }else {
                    controller.getView().stampaMessaggio("Logout non effettuato");
                }
                break;
            case 6:
                //esci
                controller.getView().stampaMessaggio("Esci dal programma");
                return false;
            default:
                //scelta non valida
                controller.getView().stampaMessaggio("Scelta non valida");
        }
        return true;

    
}
}

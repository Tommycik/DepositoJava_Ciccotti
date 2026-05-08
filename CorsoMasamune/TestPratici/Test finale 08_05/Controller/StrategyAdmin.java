package Controller;
import java.util.Scanner;
import View.GestoreTicketView;
import Model.Ticket;
//classe strategia concreta admin
public class StrategyAdmin implements StrategyMenu{
    //metodo stampaMenu
    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiAdmin();
    }
    //metodo eseguiAzioneMenu
    @Override
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        //controllo scelta
        switch(scelta) {
            case 1:
                //lista ticket
                controller.getView().stampaListaTicket(controller.getGestore().getTickets());
                break;
            case 2:
                //risolvi ticket
                controller.getView().stampaMessaggio("Inserisci id del ticket da risolvere:");
                int id = intScanner.nextInt();
                controller.getView().stampaMessaggio(controller.getGestore().risolvereTicket(id));
                break;
            case 3:
                //cancellazione ticket
                controller.getView().stampaMessaggio("Inserisci id del ticket da cancellare:");
                int id2 = intScanner.nextInt();
                controller.getView().stampaMessaggio(controller.getGestore().deleteTicket(id2));
                break;
            case 4:
                //modifica ticket
                controller.getView().stampaMessaggio("Inserisci id del ticket da modificare:");
                int id3 = intScanner.nextInt();
                controller.getView().stampaMessaggio("Inserisci nuovo titolo del ticket:");
                String titolo2 = stringScanner.nextLine();
                controller.getView().stampaMessaggio("Inserisci nuova descrizione del ticket:");
                String descrizione2 = stringScanner.nextLine();
                Ticket ticket = new Ticket(titolo2, "autore", descrizione2);
                controller.getView().stampaMessaggio(controller.getGestore().updateTicket(ticket));
                break;
            case 5:
                //cerca ticket per titolo
                controller.getView().stampaMessaggio("Inserisci titolo del ticket da cercare:");
                String titolo = stringScanner.nextLine();
                //cerca ticket
                if(controller.getGestore().searchTicket(titolo) != null) {
                    controller.getView().stampaMessaggio(controller.getGestore().searchTicket(titolo).getDescrizioneCompleta());
                }else {
                    controller.getView().stampaMessaggio("Ticket non trovato");
                }
                break;
            case 6: 
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
            case 7:
                //logout
                if(controller.getGestore().logout()) {
                    controller.getView().stampaMessaggio("Logout effettuato con successo");
                }else {
                    controller.getView().stampaMessaggio("Logout non effettuato");
                }
                break;
            case 8:
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

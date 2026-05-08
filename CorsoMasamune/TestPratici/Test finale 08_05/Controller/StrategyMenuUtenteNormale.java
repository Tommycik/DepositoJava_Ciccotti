package Controller;

import java.util.Scanner;
import View.GestoreTicketView;
import Model.Ticket;
//classe strategia concretautente
public class StrategyMenuUtenteNormale extends StrategyMenuUtente{
    //metodo per stampare menu
    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiNormale();
    }

    //helper aggiunta ticket
    private void aggiungiTicket(GestoreTicketController controller) {
        //scanner
        Scanner stringScanner = new Scanner(System.in);
        //aggiungi ticket
        controller.getView().stampaMessaggio("Inserisci titolo del ticket:");
        String titolo = stringScanner.nextLine();
        controller.getView().stampaMessaggio("Inserisci autore del ticket:");
        String autore = stringScanner.nextLine();
        controller.getView().stampaMessaggio("Inserisci descrizione del ticket:");
        String descrizione = stringScanner.nextLine();
        controller.getView().stampaMessaggio(controller.getGestore().aggiungiTicket(new Ticket(titolo, autore, descrizione)));
    }

    //metodo per eseguire azione menu
    @Override
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        Scanner stringScanner = new Scanner(System.in);
        //controllo scelta
        switch(scelta) {
            case 1:
                //aggiungi ticket
                aggiungiTicket(controller);
                break;
            case 2:
                //lista ticket
                controller.getView().stampaListaTicket(controller.getGestore().getTickets());
                break;
            case 3:
                //cerca ticket per titolo
                cercaTicket(controller);
                break;
            case 4: 
                //guarda notifiche
                visualizzaNotifiche(controller);
                break;
            case 5:
                //logout
                logout(controller);
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

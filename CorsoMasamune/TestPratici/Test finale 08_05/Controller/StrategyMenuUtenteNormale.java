package Controller;

import java.util.Scanner;
import View.GestoreTicketView;
import Model.Ticket;
//classe strategia concretautente
class StrategyMenuUtenteNormale extends StrategyMenuUtente{
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
        controller.stampaMessaggio("Inserisci titolo del ticket:");
        String titolo = stringScanner.nextLine();
        controller.stampaMessaggio("Inserisci autore del ticket:");
        String autore = stringScanner.nextLine();
        controller.stampaMessaggio("Inserisci descrizione del ticket:");
        String descrizione = stringScanner.nextLine();
        controller.stampaMessaggio(controller.getGestore().aggiungiTicket(new Ticket(titolo, autore, descrizione)));
    }

    //metodo per eseguire azione menu
    @Override
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        //controllo scelta
        switch(scelta) {
            case 1:
                //aggiungi ticket
                aggiungiTicket(controller);
                break;
            case 2:
                //lista ticket
                controller.stampaMessaggio("Lista ticket :");
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
                controller.stampaMessaggio("Esci dal programma");
                return false;
            default:
                //scelta non valida
                controller.stampaMessaggio("Scelta non valida");
        }
        return true;

    
    }
}

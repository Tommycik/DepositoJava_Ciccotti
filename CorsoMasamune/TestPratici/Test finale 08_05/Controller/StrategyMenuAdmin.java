package Controller;
import java.util.Scanner;
import View.GestoreTicketView;
import Model.Ticket;
//classe strategia concreta admin
class StrategyMenuAdmin extends StrategyMenuUtente{
    //metodo per stampare menu
    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiAdmin();
    }

    //helper modifica ticket
    private void modificaTicket(GestoreTicketController controller) {
        //scanner
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        //modifica ticket
        controller.stampaMessaggio("Inserisci id del ticket da modificare:");
        int id3 = intScanner.nextInt();
        controller.stampaMessaggio("Inserisci nuovo titolo del ticket:");
        String titolo2 = stringScanner.nextLine();
        controller.stampaMessaggio("Inserisci nuova descrizione del ticket:");
        String descrizione2 = stringScanner.nextLine();
        Ticket ticket = new Ticket(titolo2, "autore", descrizione2);
        ticket.setId(id3);
        controller.stampaMessaggio(controller.getGestore().aggiornaTicket(ticket));
    }
    
    //metodo per eseguire azione menu
    @Override
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        //scanner
        Scanner intScanner = new Scanner(System.in);
        //controllo scelta
        switch(scelta) {
            case 1:
                //lista ticket
                controller.stampaMessaggio("Lista ticket: ");
                controller.getView().stampaListaTicket(controller.getGestore().getTickets());
                break;
            case 2:
                //risolvi ticket
                controller.stampaMessaggio("Inserisci id del ticket da risolvere:");
                int id = intScanner.nextInt();
                controller.stampaMessaggio(controller.getGestore().risolvereTicket(id));
                break;
            case 3:
                //cancellazione ticket
                controller.stampaMessaggio("Inserisci id del ticket da cancellare:");
                int id2 = intScanner.nextInt();
                controller.stampaMessaggio(controller.getGestore().cancellaTicket(id2));
                break;
            case 4:
                //modifica ticket
                modificaTicket(controller);
                break;
            case 5:
                //cerca ticket per titolo
                cercaTicket(controller);
                break;
            case 6: 
                //guarda notifiche
                visualizzaNotifiche(controller);
                break;
            case 7:
                //logout
                logout(controller);
                break;
            case 8:
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

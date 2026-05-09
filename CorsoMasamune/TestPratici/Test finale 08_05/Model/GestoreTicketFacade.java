package Model;
import java.util.ArrayList;
//facade per gestire ticket
public class GestoreTicketFacade {

    //singleton
    private S_GestoreTicket s_gestoreTicket;
    //facade sessione
    private SessioneFacade sessione;

    //costruttore
    public GestoreTicketFacade() {
        s_gestoreTicket = S_GestoreTicket.getInstance();
        sessione = new SessioneFacade();
    }

    //Metodi gestione Ticket

    //aggiunta ticket
    public String aggiungiTicket(Ticket ticket) {
        if(sessione.isLogged()) {
            if(!sessione.isAdmin()) {
                if(s_gestoreTicket.aggiungiTicket(ticket)){
                    return "Ticket numero " + ticket.getId() + "con titolo " + ticket.getTitolo() + " aggiunto";
                }else {
                    return "Errore nell'aggiunta del ticket";
                }
            }else {
                return "Non hai i permessi per aggiungere ticket";
            }
        }
        return "Non hai effettuato il login";
    }

    //aggiornamento ticket
    public String aggiornaTicket(Ticket ticket) {
        if(sessione.isLogged()) {
            if(sessione.isAdmin()) {
                if(s_gestoreTicket.modificaTicket(ticket)){
                    return "Ticket numero " + ticket.getId() + "con titolo " + ticket.getTitolo() + " aggiornato";
                }else {
                    return "Errore nell'aggiornamento del ticket";
                }
            }else {
                return "Non hai i permessi per aggiornare ticket";
            }
        }
        return "Non hai effettuato il login";
    }

    //cancellazione ticket
    public String cancellaTicket(int id) {
        if(sessione.isLogged()) {
            if(sessione.isAdmin()) {
                if(s_gestoreTicket.cancellaTicket(id)){
                    return "Ticket numero " + id + " cancellato";
                }else {
                    return "Errore nella cancellazione del ticket";
                }
            }else {
                return "Non hai i permessi per cancellare ticket";
            }
        }
        return "Non hai effettuato il login";
    }

    //risolvere ticket
    public String risolvereTicket(int id) {
        if(sessione.isLogged()) {
            if(sessione.isAdmin()) {
                if(s_gestoreTicket.risolvereTicket(id)){
                    return "Ticket numero " + id + " risolto";
                }else {
                    return "Errore nel risolvere del ticket";
                }
            }else {
                return "Non hai i permessi per risolvere ticket";
            }
        }
        return "Non hai effettuato il login";
    }

    //ricerca ticket
    public Ticket cercaTicketById(int id) {
        return s_gestoreTicket.cercaTicketById(id);
    }

    public ArrayList<Ticket> cercaTicket(String titolo) {
        return s_gestoreTicket.cercaTicketsByTitolo(titolo);
    } 

    //tutti i tickets   
    public ArrayList<Ticket> getTickets() {
        return s_gestoreTicket.getTickets();
    }

    //add observer
    public void addObserver(ObserverNotifiche o) {
        s_gestoreTicket.addObserver(o);
    }
    //remove observer
    public void removeObserver(ObserverNotifiche o) {
        s_gestoreTicket.deleteObserver(o);
    }
}

package Model;
import java.util.ArrayList;
public class GestoreTicketFacade {
    private S_GestoreTicket s_gestoreTicket;
    private SessioneUtenteSistema sessione;
    //costruttore
    public GestoreTicketFacade() {
        s_gestoreTicket = S_GestoreTicket.getInstance();
        sessione = SessioneUtenteSistema.getInstance();
    }
    //Metodi gestione Ticket

    //aggiunta ticket
    public String addTicket(Ticket ticket) {
        if(SessioneUtenteSistema.getInstance().isLogged()) {
            if(!SessioneUtenteSistema.getInstance().isAdmin()) {
                if(s_gestoreTicket.addTicket(ticket)){
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
    public String updateTicket(Ticket ticket) {
        if(SessioneUtenteSistema.getInstance().isLogged()) {
            if(SessioneUtenteSistema.getInstance().isAdmin()) {
                if(s_gestoreTicket.updateTicket(ticket)){
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
    public String deleteTicket(int id) {
        if(SessioneUtenteSistema.getInstance().isLogged()) {
            if(SessioneUtenteSistema.getInstance().isAdmin()) {
                if(s_gestoreTicket.deleteTicket(id)){
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
        if(SessioneUtenteSistema.getInstance().isLogged()) {
            if(SessioneUtenteSistema.getInstance().isAdmin()) {
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
    public Ticket searchTicket(int id) {
        return s_gestoreTicket.searchTicket(id);
    }
    public Ticket searchTicket(String titolo) {
        return s_gestoreTicket.searchTicket(titolo);
    } 
    //tutti i tickets   
    public ArrayList<Ticket> getTickets() {
        return s_gestoreTicket.getTickets();
    }
    //Metodi gestione Utente
    //login
    public boolean login(UtenteSistema utente) {
        return sessione.login(utente);
    }
    //logout
    public boolean logout() {
        return sessione.logout();
    }
    //verifica login
    public boolean isLogged() {
        return sessione.isLogged();
    }
    //verifica utente
    public UtenteSistema getUtente() {
        return sessione.getUtente();
    }
    //add observer
    public void addObserver(ObserverNotifiche o) {
        s_gestoreTicket.addObserver(o);
    }
    //isAdmin
    public boolean isAdmin() {
        return sessione.isAdmin();
    }
    
}

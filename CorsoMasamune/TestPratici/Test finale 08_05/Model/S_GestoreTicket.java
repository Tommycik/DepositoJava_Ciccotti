package Model;
import java.util.ArrayList;
//S_GestoreTicket singleton
class S_GestoreTicket implements SubjectNotifiche {
    //tickets
    private ArrayList<Ticket> tickets;
    //instance
    private static S_GestoreTicket instance;
    //id progressivi
    private int id = 0;
    //observers
    private ArrayList<ObserverNotifiche> observers;
    //costruttore
    private S_GestoreTicket() {
        tickets = new ArrayList<Ticket>();
        observers = new ArrayList<ObserverNotifiche>();
    }
    //metodo getInstance
    static S_GestoreTicket getInstance() {
        if (instance == null) {
            instance = new S_GestoreTicket();
        }
        return instance;
    }
    //metodo notifica
    @Override
    public void notifica(String messaggio) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(messaggio);
        }
    }
    //metodo add e delete observer
    @Override
    public void addObserver(ObserverNotifiche o) {
        observers.add(o);
    }
    @Override
    public void deleteObserver(ObserverNotifiche o) {
        observers.remove(o);
    }
    //Operazioni CRUD

    //metodo getTickets con copia difensiva
    ArrayList<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    //metodo addTicket
    boolean addTicket(Ticket ticket) {
        ticket.setId(id);
        id++;
        tickets.add(ticket);
        notifica("Ticket numero " + ticket.getId() + " con titolo " + ticket.getTitolo() + " aggiunto");
        return true;
    }
    //metodo per aggiornare ticket per id
    boolean updateTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == ticket.getId()) {
                //mette lo stesso autore di prima
                ticket.setAutore(tickets.get(i).getAutore());
                tickets.set(i, ticket);
                notifica("Ticket numero " + ticket.getId() + " con titolo " + ticket.getTitolo() + " aggiornato");
            }
        }
        return true;
    }

    //metodo per cancellare ticket per id
    boolean deleteTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                notifica("Ticket numero " + tickets.get(i).getId() + "con titolo " + tickets.get(i).getTitolo() + " rimosso");
                tickets.remove(i);
            }
        }
        return true;
        
    }
    //metodo per cercare ticket per id
    Ticket searchTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                return tickets.get(i);
            }
        }
        return null;
    }
    // metodo per cercare ticket per titolo
    Ticket searchTicket(String titolo) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                return tickets.get(i);
            }
        }
        return null;
    }
    //risolvere ticket per id
    boolean risolvereTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                tickets.get(i).setRisolto(true);
                notifica("Ticket numero " + tickets.get(i).getId() + "con titolo " + tickets.get(i).getTitolo() + " risolto");
                return true;
            }
        }
        return false;
    }
        
}

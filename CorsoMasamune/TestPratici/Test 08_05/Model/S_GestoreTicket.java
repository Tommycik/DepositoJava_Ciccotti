import java.util.ArrayList;
//S_GestoreTicket singleton
public class S_GestoreTicket implements SubjectNotifiche {
    private ArrayList<Ticket> tickets;
    private static S_GestoreTicket instance;
    private int id = 0;
    //observers
    private ArrayList<ObserverNotifiche> observers;
    //costruttore
    private S_GestoreTicket() {
        tickets = new ArrayList<Ticket>();
        observers = new ArrayList<ObserverNotifiche>();
    }
    //metodo getInstance
    public static S_GestoreTicket getInstance() {
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

    //metodo getTickets
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    //metodo addTicket
    public boolean addTicket(Ticket ticket) {
        ticket.setId(id);
        id++;
        tickets.add(ticket);
        notifica("Ticket numero " + ticket.getId() + "con titolo " + ticket.getTitolo() + " aggiunto");
        return true;
    }
    //metodo updateTicket by id
    public boolean updateTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == ticket.getId()) {
                tickets.set(i, ticket);
            }
        }
        return true;
    }

    //metodo deleteTicket by id
    public boolean deleteTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                notifica("Ticket numero " + tickets.get(i).getId() + "con titolo " + tickets.get(i).getTitolo() + " rimosso");
                tickets.remove(i);
            }
        }
        return true;
        
    }
    //metodo searchTicket by id
        public Ticket searchTicket(int id) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getId() == id) {
                    return tickets.get(i);
                }
            }
            return null;
        }
        // metodo searchTicket by titolo
        public Ticket searchTicket(String titolo) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                    return tickets.get(i);
                }
            }
            return null;
        }
        //risolvere ticket
        public boolean risolvereTicket(int id) {
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

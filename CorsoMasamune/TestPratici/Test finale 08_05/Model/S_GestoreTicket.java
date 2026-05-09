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
    //id disponibili dopo cancellazione ticket
    ArrayList<Integer> idDisponibili;
    //observers
    private ArrayList<ObserverNotifiche> observers;
    //costruttore
    private S_GestoreTicket() {
        tickets = new ArrayList<Ticket>();
        observers = new ArrayList<ObserverNotifiche>();
        idDisponibili = new ArrayList<Integer>();
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
        ArrayList<Ticket> copia = new ArrayList<>();
        for (Ticket t : tickets) {
            //costruttore di copia
            copia.add(new Ticket(t)); 
        }
        return copia;
    }

    //metodo addTicket
    boolean aggiungiTicket(Ticket ticket) {
        //riusa gli id disponibili altrimenti aumenta l'id
        if(idDisponibili.isEmpty()) {
            ticket.setId(id);
            id++;
        }else {
            ticket.setId(idDisponibili.remove(0));
        }
        tickets.add(ticket);
        notifica("Ticket con id " + ticket.getId() + " con titolo " + ticket.getTitolo() + " aggiunto\n");
        return true;
    }
    //metodo per aggiornare ticket per id
    boolean modificaTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == ticket.getId()) {
                //mette lo stesso autore di prima
                ticket.setAutore(tickets.get(i).getAutore());
                tickets.set(i, ticket);
                notifica("Ticket con id " + ticket.getId() + " con titolo " + ticket.getTitolo() + " aggiornato\n");
                return true;
            }
        }
        return false;
    }

    //metodo per cancellare ticket per id
    boolean cancellaTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                notifica("Ticket con id " + tickets.get(i).getId() + " con titolo " + tickets.get(i).getTitolo() + " rimosso\n");
                tickets.remove(i);
                idDisponibili.add(id);
                return true;
            }
        }
        return false;
    }
    //metodo per cercare ticket per id
    Ticket cercaTicketById(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                //creazione nuovo ticket con costruttore di copia
                return new Ticket(tickets.get(i));
            }
        }
        return null;
    }
    // metodo per cercare ticket per titolo
    ArrayList<Ticket> cercaTicketsByTitolo(String titolo) {
        ArrayList<Ticket> ticketsTrovati= new ArrayList<Ticket>();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                //creazione nuovo ticket con costruttore di copia
                ticketsTrovati.add(new Ticket(tickets.get(i)));
            }
        }
        if(!ticketsTrovati.isEmpty()) {
            return ticketsTrovati;
        }else {
            return null;
        }
    }
    //risolvere ticket per id
    boolean risolvereTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                tickets.get(i).setRisolto(true);
                notifica("Ticket con id " + tickets.get(i).getId() + " con titolo " + tickets.get(i).getTitolo() + " risolto\n");
                return true;
            }
        }
        return false;
    }
        
}

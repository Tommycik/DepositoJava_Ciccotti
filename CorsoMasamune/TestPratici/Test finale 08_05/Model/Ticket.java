package Model;
//classe ticket
public class Ticket {
    private int id;
    private String titolo;
    private String autore;
    private String descrizione;
    private boolean risolto = false;
    
    //costruttore
    public Ticket(String titolo, String autore, String descrizione) {
        this.id = 0;
        this.titolo = titolo;
        this.autore = autore;
        this.descrizione = descrizione;
    }
    //costruttore di copia 
    public Ticket(Ticket other) {
        this.id = other.getId();
        this.titolo = other.getTitolo();
        this.autore = other.getAutore();
        this.descrizione = other.getDescrizione();
        this.risolto = other.isRisolto();
    }
    
    //getter
    public int getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public boolean isRisolto() {
        return risolto;
    }
    //setter
    public void setRisolto(boolean risolto) {
        this.risolto = risolto;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setId(int id) {
        this.id = id;
    }
    //descrizione completa
    public String getDescrizioneCompleta() {
        return "Id: "+ id + ". " + titolo + " di " + autore + " con descrizione:\n" + descrizione + "\nRisolto: " + risolto;
    }
    
}

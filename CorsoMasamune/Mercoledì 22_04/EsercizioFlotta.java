import java.util.ArrayList;

public class EsercizioFlotta {
    public static void main(String[] args) {
        //crea 2 aerei e 2 piloti
        Aereo aereo1 = new Aereo("A320", 4, "123456789");
        Aereo aereo2 = new Aereo("A321", 4, "123456789");
        Pilota pilota1 = new Pilota("Tommy", 5, "123456789");
        Pilota pilota = new Pilota("Maria", 5, "123456789");
        //crea la compagnia
        CompagniaAerea compagnia = new CompagniaAerea("Compagnia 1");  
        //aggiungo i piloti e gli aerei
        compagnia.aggiungiPilota(pilota1);
        compagnia.aggiungiPilota(pilota);   
        compagnia.aggiungiAereo(aereo1);
        compagnia.aggiungiAereo(aereo2);
        //stampa informazioni della compagnia
        compagnia.stampa();
    }
}

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti);
        this.codice = codice;
    }
    //getter
    public String getModello() {
        return modello;
    }
    public int getNumeroPosti() {
        return numeroPosti;
    }
    public String getCodice() {
        return codice;
    }   

    //setter
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setNumeroPosti(int numeroPosti) {
        if(numeroPosti>0) {
            this.numeroPosti = numeroPosti;
        }else {
            System.out.println("Numero di posti non valido");
        }
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }

    //metodi pubblici
    public void stampa() {
        System.out.println("modello: " + modello + " codice: " + codice + " numero di posti: " + numeroPosti);
    }
}

class Pilota{
    private String nome;
    private int oreVolo;
    private String numeroBrevetto;

    public Pilota(String nome, int oreVolo, String numeroBrevetto) {
        this.nome = nome;
        this.oreVolo = oreVolo;
        this.numeroBrevetto = numeroBrevetto;
    }

    //getter
    public String getNome() {
        return nome;
    }
    public int getOreVolo() {
        return oreVolo;
    }
    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setOreVolo(int oreVolo) {
        if(oreVolo>0) {
            this.oreVolo = oreVolo;
        }else {
            System.out.println("Ore di volo non valide");
        }
    }
    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    //metodi pubblici
    public void stampa() {
        System.out.println("Pilota: " + nome + " ore di volo: " + oreVolo + " numero del brevetto: " + numeroBrevetto);
    }
}

class CompagniaAerea{
    private String nome;
    ArrayList<Aereo> flotta = new ArrayList<Aereo>();
    ArrayList<Pilota> piloti = new ArrayList<Pilota>();

    public CompagniaAerea(String nome) {
        this.nome = nome;
    }

    //getter
    public String getNome() {
        return nome;
    }

    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    //aggiungi aereo
    public void aggiungiAereo(Aereo a) {
        flotta.add(a);
    }
    //aggiungi pilota
    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }
    //metodi pubblici
    public void stampa() {
        System.out.println("La compagnia è " + nome);
        for(Aereo a : flotta) {
            a.stampa();
        }
        for(Pilota p : piloti) {
            p.stampa();
        }
    }
}
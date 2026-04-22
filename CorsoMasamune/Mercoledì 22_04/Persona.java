
public class Persona {
    // variabili private
    private String nome;
    private String cognome;
    private int età;
    // variabili pubbliche
    public String indirizzo;
    public String nazionalità;

    // costruttore
    public Persona(String nome, String cognome, int età, String indirizzo, String nazionalità) {
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
        this.indirizzo = indirizzo;
        this.nazionalità = nazionalità;
        System.out.println(descrizione());
    }

    // getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public void saluta() {
        System.out.println("Ciao sono " + nome + " " + cognome + ", età: " + età+ " anni e vivo a " + indirizzo + " in " + nazionalità);    
    }
    // può essere utile per fare check sulle proprietà della classe
    private String descrizione() {
        return nome + " , " + cognome + " , " + età+ " , " + indirizzo + " , " + nazionalità;
    }
    //metodo interno
    private boolean isMaggiorenne() {
        return età > 18;
    }

    //metodo pubblico che fa uso di un metodo interno
    public void stampaStatus() {
        if(isMaggiorenne()) {
            System.out.println("Sono " + nome + " " + cognome + " e sono maggiorenne");
        } else {
            System.out.println("Sono " + nome + " " + cognome + " e non sono maggiorenne");
        }
    }
}

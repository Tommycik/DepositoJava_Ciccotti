public class EsercizioPersona {
    public static void main(String[] args){
        //Creazione di una persona completa
        Persona p = new Persona("Tommy", "Milano", 25);
        //Stampa i dettagli
        p.stampaDettagli();

        //Creazione di una persona con solo nome e città
        Persona p2 = new Persona("Matteo", "Pisa");
        p2.stampaDettagli();

        //Creazione di una persona senza parametri
        Persona p3 = new Persona();
        p3.stampaDettagli();
        // Modifica i dati
        p3.nome = "Franco";
        p3.città = "Torino";
        p3.età = 25;
        p3.stampaDettagli();
    }
    
}

class Persona{
    String nome;
    String città;
    int età;

    // Costruttore senza parametri
    public Persona(){
        this.nome = "nome";
        this.città = "città";
        this.età = 0;
    }
    
     // Costruttore altra versione
    public Persona(String nome, String città){
        this.nome = nome;
        this.città = città;
        this.età = 0;
    }

    // Costruttore
    public Persona(String nome, String città, int età){
        this.nome = nome;
        this.città = città;
        this.età = età;
    }

    public void stampaDettagli(){
        System.out.println("Nome: " + nome + " età: " + età + " città: " + città);
    }
}


public class EsercizioLibro {
    //Classe libro
     public static void main(String[] args) {
        //Creazione di un libro
        Libro libro = new Libro("Il giorno del giovane", "Giovanni Bonino", 100);
        // Creazione secondo libro 
        Libro libro2 = new Libro("Il giorno del vecchio", "Marco Bonino", 120);
        //Stampa i dettagli
        libro.stampaDettagli();
        libro2.stampaDettagli();
     }
}
//Classe libro
class Libro{

    private static int codice_numerico_autoincrementante = 0;
    
    String titolo;
    String autore;
    int prezzo;
    int codice;

    public Libro(String titolo, String autore, int prezzo){
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        this.codice = codice_numerico_autoincrementante;
        codice_numerico_autoincrementante++;
    }

    // Stampa i dettagli
    public void stampaDettagli(){
        System.out.println("Titolo: " + titolo);
        System.out.println("Autore: " + autore);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Codice numerico: " + codice);
    }

}


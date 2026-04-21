 // classe auto
public class Auto{
    String marca;
    String modello;
    int anno;
    double prezzo;
    static int numeroRuote = 4;

    // Stampa attributi
    public void mostraInfo(){
        System.out.println("La macchina è una " + marca + " " + " modello " + modello + " " + " dell'anno " + anno + " prezzo " +prezzo);
    }
}


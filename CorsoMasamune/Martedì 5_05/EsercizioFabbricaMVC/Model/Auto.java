package EsercizioFabbricaMVC.Model;
//classe Auto
public class Auto extends Veicolo {
    //costruttore
    public Auto(String nome, String targa) {
        super(nome , targa);
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return "Auto: " + nome + " con targa " + targa;
    }
}
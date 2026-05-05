package EsercizioFabbricaMVC.Model;
//classe Moto
public class Moto extends Veicolo {
    //costruttore
    public Moto(String nome , String targa) {
        super(nome , targa);
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return "Moto: " + nome + " con targa " + targa;
    }
}
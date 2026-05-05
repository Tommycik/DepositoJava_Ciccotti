package EsercizioFabbricaMVC.Model;
//classe astratta per rappresentare un veicolo
public abstract class Veicolo implements Component {
    protected String nome;
    protected String targa;
    //costruttore
    public Veicolo(String nome,String targa) {
        this.nome = nome;
        this.targa = targa;
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return "Veicolo: " + nome + " con targa " + targa;
    }
    //override metodo per ottenere il nome
    @Override
    public String getNome() {
        return nome;
    }
    //override metodo per ottenere la targa
    @Override
    public String getTarga() {
        return targa;
    }
}
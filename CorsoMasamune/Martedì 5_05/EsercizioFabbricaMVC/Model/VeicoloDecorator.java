package EsercizioFabbricaMVC.Model;

//classe astratta per rappresentare un decorator
public abstract class VeicoloDecorator implements Component {

    protected Component veicolo;
    //costruttore
    public VeicoloDecorator(Component v) {
        this.veicolo = v;
    }
    // override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione();
    }
    //override metodo per ottenere il nome
    @Override
    public String getNome() {
        return veicolo.getNome();
    }
    //override metodo per ottenere la targa
    @Override
    public String getTarga() {
        return veicolo.getTarga();
    }
}
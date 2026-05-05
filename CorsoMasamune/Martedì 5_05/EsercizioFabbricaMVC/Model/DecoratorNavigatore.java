package EsercizioFabbricaMVC.Model;

public class DecoratorNavigatore extends VeicoloDecorator {
    //costruttore
    public DecoratorNavigatore(Component v) {
        super(v);
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con navigatore satellitare";
    }
}

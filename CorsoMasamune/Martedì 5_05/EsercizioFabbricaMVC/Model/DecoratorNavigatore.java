package EsercizioFabbricaMVC.Model;

public class DecoratorNavigatore extends VeicoloDecorator {
    //costruttore
    public DecoratorNavigatore(Component v) {
        super(v);
    }
    
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con navigatore satellitare";
    }
}

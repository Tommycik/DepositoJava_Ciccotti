package EsercizioFabbricaMVC.Model;

public class DecoratorMultimediale extends VeicoloDecorator {
    //costruttore
    public DecoratorMultimediale(Component v) {
        super(v);
    }
    
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con sistema multimediale";
    }
    
}

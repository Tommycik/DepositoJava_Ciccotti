package EsercizioFabbricaMVC.Model;

public class DecoratorMultimediale extends VeicoloDecorator {
    //costruttore
    public DecoratorMultimediale(Component v) {
        super(v);
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con sistema multimediale";
    }
    
}

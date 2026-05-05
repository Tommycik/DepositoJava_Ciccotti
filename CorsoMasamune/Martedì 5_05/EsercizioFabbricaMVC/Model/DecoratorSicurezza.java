package EsercizioFabbricaMVC.Model;

public class DecoratorSicurezza extends VeicoloDecorator{
    //costruttore
    public DecoratorSicurezza(Component v) {
        super(v);
    }
    //override metodo per la descrizione
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con airbag di sicurezza";
    }
}

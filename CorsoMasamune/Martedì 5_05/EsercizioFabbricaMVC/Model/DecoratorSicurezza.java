package EsercizioFabbricaMVC.Model;

public class DecoratorSicurezza extends VeicoloDecorator{
    public DecoratorSicurezza(Component v) {
        super(v);
    }
    
    @Override
    public String getDescrizione() {
        return veicolo.getDescrizione() + " con airbag di sicurezza";
    }
}

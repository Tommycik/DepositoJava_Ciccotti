public class EsercizioFacileDecorator {
    public static void main(String[] args) {
        //Creazione componente
        Messaggio component = new MessaggioBase();
        //Stampa contenuto
        System.out.println(component.getContenuto());
        //Creazione decorator
        Messaggio decorator = new DecoratorMaiuscolo(component);
        //Stampa contenuto decorato
        System.out.println(decorator.getContenuto());
    }
}
// Interfaccia component
interface Messaggio{
    String getContenuto();
}
//Componente concreto
class MessaggioBase implements Messaggio{
    @Override
    public String getContenuto() {
        return "Messaggio base";
    }
}
// Decorator astratto
abstract class DecoratorMessaggio implements Messaggio{
    //campo componente
    private Messaggio component;
    public DecoratorMessaggio(Messaggio component){
        this.component = component;
    }
    //override getContenuto
    @Override
    public String getContenuto(){
        return component.getContenuto();
    }
}
//Decorator concreto
class DecoratorMaiuscolo extends DecoratorMessaggio{
    //costruttore
    public DecoratorMaiuscolo(Messaggio component){
        super(component);
    }
    //override getContenuto
    @Override
    public String getContenuto(){
        return super.getContenuto().toUpperCase();
    }
}

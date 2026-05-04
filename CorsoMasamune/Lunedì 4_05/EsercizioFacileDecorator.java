import java.util.Scanner;

public class EsercizioFacileDecorator {

    public static void main(String[] args) {
        //Creazione componente
        Messaggio component = new MessaggioBase("ciao");
        //Stampa contenuto
        System.out.println(component.getContenuto());
        //Creazione decorator
        Messaggio decorator = new DecoratorMaiuscolo(component);
        //Stampa contenuto decorato
        System.out.println(decorator.getContenuto());
        //ciclo while e menu per inserimento
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Inserisci un comando:");
            System.out.println("1. Esci");
            System.out.println("2. Stampa messaggio");
            int scelta = intScanner.nextInt();
            String contenuto = null;
            switch(scelta){
                case 1:
                    //esci
                    System.out.println("Uscita dal programma");
                    return;
                case 2:
                    //stampa contenuto
                    //inserisci contenuto da utente
                    System.out.println("Inserisci il contenuto");
                    contenuto = stringScanner.nextLine();
                    //Stampare contenuto o usare anche decoratore
                    System.out.println("Stampa contenuto normale o maiuscolo? (1/2)");
                    int scelta2 = intScanner.nextInt();
                    switch(scelta2){
                        case 1:
                            //stampa contenuto
                            System.out.println(new MessaggioBase(contenuto).getContenuto());
                            break;
                        case 2:
                            //stampa contenuto decorato
                            System.out.println(new DecoratorMaiuscolo(new MessaggioBase(contenuto)).getContenuto());
                            break;
                        default:
                            //scelta non valida
                            System.out.println("Scelta non valida");
                    }
                    
                    break;
                default:
                    //scelta non valida
                    System.out.println("Scelta non valida");
            }
        }
    }
}
// Interfaccia component
interface Messaggio{
    String getContenuto();
}
//Componente concreto
class MessaggioBase implements Messaggio{
    String contenuto;
    //costruttore
    public MessaggioBase(String contenuto){
        this.contenuto = contenuto;
    }
    @Override
    public String getContenuto() {
        return contenuto;
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

import java.util.Scanner;
public class EsercizioMedioDecorator {
    public static void main(String[] args) {
        // Scanner per input
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        //ciclo while con menu pe rutente
        while(true){
            System.out.println("Inserisci ordine:");
            System.out.println("1. Esci");
            System.out.println("2. Hamburger Base");
            System.out.println("3. Hamburger con formaggio");
            System.out.println("4. Hamburger con bacon");
            System.out.println("5. Hamburger con formaggio e bacon");
            int scelta = intScanner.nextInt();   
            Hamburger component = null;
            switch(scelta){
                case 1:
                    //esci
                    System.out.println("Uscita dal programma");
                    return;
                case 2:
                    //Hamburger Base
                    //stampare descrizione e prezzo
                    component = new HamburgerBase();
                    System.out.println("\nHai ordinato:");
                    System.out.println(component.getDescrizione() + " con prezzo di " + component.getprezzo() + " euro");
                    break;
                case 3:
                    //Hamburger con formaggio
                    //stampare descrizione e prezzo
                    component = new DecoratorFormaggio(new HamburgerBase());
                    System.out.println("\nHai ordinato:");
                    System.out.println(component.getDescrizione() + " con prezzo di " + component.getprezzo() + " euro");
                    break;
                case 4:
                    //Hamburger con bacon
                    //stampare descrizione e prezzo
                    component = new DecoratorBacon(new HamburgerBase());
                    System.out.println("\nHai ordinato:");
                    System.out.println(component.getDescrizione() + " con prezzo di " + component.getprezzo() + " euro");
                    break;
                case 5:
                    //Hamburger con formaggio e bacon
                    //stampare descrizione e prezzo
                    component = new DecoratorBacon(new DecoratorFormaggio(new HamburgerBase()));
                    System.out.println("\nHai ordinato:");
                    System.out.println(component.getDescrizione() + " con prezzo di " + component.getprezzo() + " euro");
                    break;
                default:
                    //scelta non valida
                    System.out.println("Scelta non valida");
            }
        }
    }
}
//Interfaccia hamburger
interface Hamburger{
    String getDescrizione();
    double getprezzo();
}

//Componente concreto
class HamburgerBase implements Hamburger{
    //override getDescrizione
    @Override
    public String getDescrizione() {
        return "Hamburger Base";
    }
    //override getprezzo
    @Override
    public double getprezzo() {
        return 10.0;
    }
}

//Decorator astratto
abstract class DecoratorHamburger implements Hamburger{
    //campo componente
    private Hamburger component;
    public DecoratorHamburger(Hamburger component){
        this.component = component;
    }
    //override getDescrizione
    @Override
    public String getDescrizione(){
        return component.getDescrizione();
    }
    //override getprezzo
    @Override
    public double getprezzo(){
        return component.getprezzo();
    }
}
//Decorator concreto formaggio
class DecoratorFormaggio extends DecoratorHamburger{
    //costruttore
    public DecoratorFormaggio(Hamburger component){
        super(component);
    }
    //override getDescrizione
    @Override
    public String getDescrizione(){
        return super.getDescrizione() + " con formaggio";
    }
    //override getprezzo
    @Override
    public double getprezzo(){
        return super.getprezzo() + 0.5;
    }
}
// Decorator concreto bacon
class DecoratorBacon extends DecoratorHamburger{
    //costruttore
    public DecoratorBacon(Hamburger component){
        super(component);
    }
    //override getDescrizione
    @Override
    public String getDescrizione(){
        return super.getDescrizione() + " con bacon";
    }
    //override getprezzo
    @Override
    public double getprezzo(){
        return super.getprezzo() + 0.8;
    }
}

import java.util.Scanner;
public class EsercizioFacade {
    public static void main(String[] args) {
        FacadeLampadine facade = new FacadeLampadine();
        //ciclo while e menu per far scegliere all'utente
        Scanner intScanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("1. Accendi la luce lampeggiando");
            System.out.println("2. Accendi la luce bianca");
             System.out.println("3. Accendi la luce normale");
            System.out.println("4. Esci");
            int scelta = intScanner.nextInt();
            switch (scelta) {
                case 1 :
                    //accende la luce lampeggiando
                    facade.accendiLampeggio();
                    break;
                case 2 :
                    //accende la luce bianca
                    facade.accendiBianche();
                    break;
                case 3 :
                    //accende la luce normale
                    facade.accendi();
                    break;
                case 4 :
                    //esci
                    System.out.println("Arrivederci");
                    continueLoop = false;
                    break;
                default :
                    //scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}
// Sottosistemi
//Classe luce astratta con strategy
abstract class Luce {
    protected Modifica strategy;

    public void setStrategy(Modifica strategy) {
        this.strategy = strategy;
    }

    public String modifica(String messaggio) {
        return strategy.aggiunta(messaggio);
    }
    //metodo astratto per accendere la luce
    abstract void accendi();
}
//classe luce Camera
class LuceCamera extends Luce {
    public void accendi() {
        String messaggio = "Luci camera accese";
        if(strategy != null){
            messaggio = modifica(messaggio);
        }
        System.out.println(messaggio);
    }
}

class LuceCucina extends Luce {
    public void accendi() {
        String messaggio = "Luci cucina accese";
        if(strategy != null){
            messaggio = modifica(messaggio);
        }
        System.out.println(messaggio);
    }
}
//interfacccia Strategy
interface Modifica {
    String aggiunta(String messaggio);
}

// Strategie Concrete
class ConcreteStrategyLampeggio implements Modifica {
    public String aggiunta(String messaggio) {
        return messaggio + "  ma lampeggiano";
    }
}

class ConcreteStrategyBianche implements Modifica {
    public String aggiunta(String messaggio) {
        return messaggio + "  ma bianche";
    }
}
//Facade
class FacadeLampadine {
    private LuceCamera luceCamera = new LuceCamera();
    private LuceCucina luceCucina = new LuceCucina();
    //metodo per accendere la luce
    public void accendi() {
        luceCamera.setStrategy(null);
        luceCucina.setStrategy(null);
        luceCamera.accendi();
        luceCucina.accendi();
    }
    //metodo per accendere la luce lampeggiando
    public void accendiLampeggio() {
        luceCamera.setStrategy(new ConcreteStrategyLampeggio());
        luceCamera.accendi();
        luceCucina.setStrategy(new ConcreteStrategyLampeggio());
        luceCucina.accendi();
    }
    //metodo per accendere la luce bianche
    public void accendiBianche() {
        luceCamera.setStrategy(new ConcreteStrategyBianche());
        luceCamera.accendi();
        luceCucina.setStrategy(new ConcreteStrategyBianche());
        luceCucina.accendi();
    }
}
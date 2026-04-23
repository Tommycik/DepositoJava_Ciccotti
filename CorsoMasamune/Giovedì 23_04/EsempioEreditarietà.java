
public class EsempioEreditarietà {
    public static void main(String[] args) {
        //Instanzia la macchina
        Car ferrari = new Car("Ferrari", "488 GTB");
        //Chiama il metodo classe padre
        ferrari.honk();
        //Chiama il metodo classe figlia
        ferrari.stampa();
    }
}

class Vehicle {
    protected String brand;
    
    public Vehicle() {
        brand = "No brand";
    }
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    public void honk() {
        System.out.println("Honk!");
    }
}
class Car extends Vehicle{
    //Solo inizializzabile e poi non più modificabile
    final protected String modello;

    //Costruttore
    public Car(String brand, String modello) {
        //Chiama il costruttore della classe padre
        super(brand);
        this.modello = modello;
    }

    public void stampa() {
        //Può accedere alle variabili protected della classe padre
        System.out.println(brand + " " + modello);
    }
    //Override del metodo della classe padre
    @Override
    public void honk() {
        //Chiama il metodo della classe padre
        super.honk();
        System.out.println("Spostati!");
    }

}

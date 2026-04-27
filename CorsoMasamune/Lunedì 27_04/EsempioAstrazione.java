
public class EsempioAstrazione {
    public static void main(String[] args) {
        //creazione di un oggetto sottotipo di animale
        Animal animal = new Pig();
        //Prova dei metodi implementati nelle classi filgie
        animal.makeSound();
        animal.sleep();
        animal = new Dog();
        animal.makeSound();
        animal.sleep();
    }
}
// classe astratta
abstract class Animal{
    // metodo astratto
    abstract void makeSound();
    public void sleep(){
        System.out.println("Animal sleeping");
    }    
}

// classe ereditata
class Pig extends Animal{
    //implementazione metodo astratto
    public void makeSound(){
        System.out.println("Pig");
    }
}   
// classe ereditata
class Dog extends Animal{
    public void makeSound(){
        System.out.println("Dog");
    }
}


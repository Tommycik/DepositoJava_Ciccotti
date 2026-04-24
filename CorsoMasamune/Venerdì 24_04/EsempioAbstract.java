//classe astratta
abstract class Animal{

    // metodo astratto,deve essere implementato nelle classi che ereditano da Animal
    abstract void makeSound();
}

//classe astratta implementata
class Dog extends Animal{
    //override
    @Override
    void makeSound(){
        System.out.println("Woof!");
    }
}

class Cat extends Animal implements Movement{
    //override
    @Override
    void makeSound(){
        System.out.println("Meow!");
    }
    @Override
    public void move(){
        System.out.println("Vai a casa");
    }
    @Override
    public void stop(){
        System.out.println("Arrivederci");
    }
}
class Cow extends Animal implements Movement{
    @Override
    public void makeSound(){
        System.out.println("Meow!");
    }
    @Override
    public void move(){
        System.out.println("Vai a casa");
    }
    @Override
    public void stop(){
        System.out.println("Arrivederci");
    }
}

public class EsempioAbstract{
    public static void main(String[] args){
        Animal dog = new Dog();
        //Metodi interfaccia non fanno parte di Animal
        Cat cat = new Cat();
        dog.makeSound();
        cat.makeSound();
        cat.move();
        cat.stop();
    }
}

//interfaccia
interface Movement {
    public void move();
    public void stop(); 
}
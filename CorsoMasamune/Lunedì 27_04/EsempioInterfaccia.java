
//interfaccia
interface Animale{
    void makeSound();
    void sleep();
}
class Cat implements Animale{
    //implementa metodi astratti dell'interfaccia
    public void makeSound(){
        System.out.println("Miao");
    }
    public void sleep(){
        System.out.println("zzzzz");
    }
}
public class EsempioInterfaccia {
    public static void main(String[] args) {
        Cat cat = new Cat();
        //Prova dei metodi implementati nella classe filgia
        cat.makeSound();
        cat.sleep();
    }
}
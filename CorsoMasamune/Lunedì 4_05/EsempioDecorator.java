//Esempio di decorator e component
public class EsempioDecorator{
    public static void main(String[] args){
        Component component = new ConcreteComponent();
        component.operation();
        //Usiamo il decorator
        Component decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
//Interfaccia component
/*interface Component{
    //metodo di interfaccia
    void operation();
}*/
//Componente concreto
class ConcreteComponent implements Component{
    //implementazione dell'interfaccia
    @Override
    public void operation(){
        System.out.println("operazione base");
    }
}
//decorator astratto, può essere astratto
abstract class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void operation(){
        component.operation();
    }
}

//Decorator concreto
class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component){
        super(component);
    }
    @Override
    public void operation(){
        super.operation();
        System.out.println("funzionalità aggiuntiva");
    }
}
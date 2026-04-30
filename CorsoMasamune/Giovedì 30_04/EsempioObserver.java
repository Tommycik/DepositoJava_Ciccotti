
import java.util.ArrayList;
import java.util.List;


public class EsempioObserver {
    
}
//interfaccia observer 
interface Observer{
    void update(String message);
}
//interfaccia subject 
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
//implementazione subject
class ConcreteSubject implements Subject {
    //lista degli observer
    private List<Observer> observers = new ArrayList<>();
    private String state;
    //setter
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
    //getter
    public String getState() {
        return state;
    }
    //override registerObserver
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    //override removeObserver
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    //override notifyObservers
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}
// implementazione observer
class ConcreteObserver implements Observer {
    private String name;
    //costruttore
    public ConcreteObserver(String name) {
        this.name = name;
    }
    //override update
    @Override
    public void update(String message) {
        System.out.println(name + " ha ricevuto un aggiornamento: " + message);
    }
}

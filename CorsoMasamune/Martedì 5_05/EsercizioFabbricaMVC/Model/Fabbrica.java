package EsercizioFabbricaMVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Fabbrica implements Subject {

    private static Fabbrica instance;

    private List<Component> veicoli = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Fabbrica() {}

    public static Fabbrica getInstance() {
        if (instance == null) {
            instance = new Fabbrica();
        }
        return instance;
    }

    public void creaVeicolo(Component c) {
        veicoli.add(c);
        notificaObserver(c);
    }

    public List<Component> getVeicoli() {
        return veicoli;
    }

    @Override
    public void aggiungiObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notificaObserver(Component c) {
        for (Observer o : observers) {
            o.aggiorna(c);
        }
    }
}
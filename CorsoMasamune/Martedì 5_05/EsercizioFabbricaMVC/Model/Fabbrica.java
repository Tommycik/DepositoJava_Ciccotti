package EsercizioFabbricaMVC.Model;

import java.util.ArrayList;
//classe Fabbrica
public class Fabbrica implements Subject {
    //Istanza privata
    private static Fabbrica instance;
    //veicoli
    private ArrayList<Component> veicoli = new ArrayList<>();
    //observers
    private ArrayList<Observer> observers = new ArrayList<>();
    //costruttore privato
    private Fabbrica() {}
    //metodo per ottenere istanza
    public static Fabbrica getInstance() {
        if (instance == null) {
            instance = new Fabbrica();
        }
        return instance;
    }
    //metodo per creare un veicolo
    public void creaVeicolo(Component c) {
        veicoli.add(c);
        notificaObserver(c);
    }
    //metodo per ottenere i veicoli
    public ArrayList<Component> getVeicoli() {
        return veicoli;
    }
    //metodo per aggiungere un observer
    @Override
    public void aggiungiObserver(Observer o) {
        observers.add(o);
    }
    //metodo per notificare gli observer
    @Override
    public void notificaObserver(Component c) {
        for (Observer o : observers) {
            o.aggiorna(c);
        }
    }
}
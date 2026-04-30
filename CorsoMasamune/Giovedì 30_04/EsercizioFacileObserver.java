import java.util.ArrayList;
import java.util.List;
public class EsercizioFacileObserver {
    public static void main(String[] args) {
        //creazione della stazione meteo
        System.out.println("Creazione della stazione meteo");
        stazioneMeteo stazione = new stazioneMeteo();
        //creazione degli observer
        DisplayConsole console = new DisplayConsole();
        DisplayMobile mobile = new DisplayMobile();
        //aggiungi gli observer
        stazione.addDisplay(console);
        stazione.addDisplay(mobile);
        //imposta la temperatura
        stazione.setTemperatura(25);
        //rimuovi gli observer
        stazione.removeDisplay(console);
        stazione.removeDisplay(mobile);
        //creazione termometro
        System.out.println("Creazione termometro");
        Termometro termometro = new Termometro();
        //aggiungi gli observer
        termometro.addDisplay(console);
        termometro.addDisplay(mobile);
        //imposta la temperatura
        termometro.setTemperatura(25);
        //rimuovi gli observer
        termometro.removeDisplay(console);
        termometro.removeDisplay(mobile);
    }
}

//interfaccia display 
interface Display{
    void update(float temperatura);
}
//implementazione display
class DisplayConsole implements Display {
    //override update
    @Override
    public void update(float temperatura) {
        System.out.println("Temperatura attuale: " + temperatura);
    }
}

class DisplayMobile implements Display {
    //override update
    @Override
    public void update(float temperatura) {
        System.out.println("Temperatura in questo momento: " + temperatura);
    }
}
//interfaccia subject
interface Subject {
    void addDisplay(Display d);
    void removeDisplay(Display d);
    void notifyObservers();
}
//subject 
class Termometro implements Subject {
    //lista degli observer
    private List<Display> displays = new ArrayList<>();
    private float temperatura;
    //setter
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notifyObservers();
    }
    //getter
    public float getTemperatura() {
        return temperatura;
    }
    //aggiungi display
    public void addDisplay(Display d) {
        displays.add(d);
    }
    //rimuovi display
    public void removeDisplay(Display d) {
        displays.remove(d);
    }
    //notifica gli observer
    public void notifyObservers() {
        for (Display o : displays) {
            o.update(temperatura);
        }
    }
}
//Subject
class stazioneMeteo implements Subject {
    //lista degli observer
    private List<Display> displays = new ArrayList<>();
    private float temperatura;
    //setter
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notifyObservers();
    }
    //getter
    public float getTemperatura() {
        return temperatura;
    }
    //aggiungi display
    public void addDisplay(Display d) {
        displays.add(d);
    }
    //rimuovi display
    public void removeDisplay(Display d) {
        displays.remove(d);
    }
    //notifica gli observer
    public void notifyObservers() {
        for (Display o : displays) {
            o.update(temperatura);
        }
    }
}

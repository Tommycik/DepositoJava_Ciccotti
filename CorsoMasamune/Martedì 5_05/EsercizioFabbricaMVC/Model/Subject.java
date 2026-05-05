package EsercizioFabbricaMVC.Model;

//interfaccia per rappresentare un subject
public interface Subject {
    void aggiungiObserver(Observer o);
    void notificaObserver(Component c);
}

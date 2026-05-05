package EsercizioFabbricaMVC.Model;


public interface Subject {
    void aggiungiObserver(Observer o);
    void notificaObserver(Component c);
}

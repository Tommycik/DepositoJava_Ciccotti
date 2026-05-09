package Model;
//interface subject notifiche
interface SubjectNotifiche {
    void notifica(String messaggio);
    void addObserver(ObserverNotifiche o);
    void deleteObserver(ObserverNotifiche o);
}

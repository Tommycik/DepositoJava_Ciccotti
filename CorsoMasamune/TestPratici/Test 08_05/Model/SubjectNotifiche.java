public interface SubjectNotifiche {
    public void notifica(String messaggio);
    public void addObserver(ObserverNotifiche o);
    public void deleteObserver(ObserverNotifiche o);
}

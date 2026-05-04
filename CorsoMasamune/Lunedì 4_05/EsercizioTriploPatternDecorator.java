import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EsercizioTriploPatternDecorator{
    public static void main(String[] args) {
        //creazione Sistema di notifica
        NotificationManager notificationManager = NotificationManager.getInstance();
        //creazione Utente
        Utente utenteProva = new Utente("Mario", "1234");
        //creazione decorator
        DecoratorMaiuscolo maiuscolo = new DecoratorMaiuscolo(utenteProva);
        DecoratorTimestamp timestamp = new DecoratorTimestamp(maiuscolo);
        DecoratorEmoji emoji = new DecoratorEmoji(timestamp);
        //aggiunta utente a notifica
        notificationManager.addObserver(emoji);
        //creazione utente normale
        Utente utenteNormale = new Utente("Franco", "1234");
        notificationManager.addObserver(utenteNormale);
        //notifica utenti
        notificationManager.notifyObservers("Messaggio di prova");
        //Scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        //lista degli utenti
        List<Component> utenti = new ArrayList<>();
        utenti.add(utenteNormale);
        utenti.add(emoji);
        while(true){
            //menu
            System.out.println("\n1. Registrazione utente e richiesta notifiche");
            System.out.println("2. Login");
            System.out.println("3. Invia notifica");
            System.out.println("4. Richiedi notifica");
            System.out.println("5. Smetti di ricevere notifiche");
            System.out.println("6. Logout");
            System.out.println("7. Esci");
            int scelta = intScanner.nextInt();
            Component utente = null;
            Observer observer = null;
            boolean valid=true;
            switch (scelta){
                //scelta utente
                case 1:
                    //registrazione utente
                    System.out.println("Inserisci il tuo nome: ");
                    String nomeUtente = stringScanner.nextLine();
                    System.out.println("Inserisci la password: ");
                    String password = stringScanner.nextLine();
                    System.out.println("Tipo: 1=TimeStamp, 2=Maiuscolo, 3=Emoji, 4=Normale, 5=Tutti");
                    int tipo = intScanner.nextInt();
                    //controlla doppioni
                    for (Component u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeUtente)) {
                            System.out.println("Utente già presente");
                            break;
                        }
                    }
                    //creazione utente base
                    utente = new Utente(nomeUtente, password);
                    switch (tipo) {
                        case 1:
                            // TimeStamp
                            utente = new DecoratorTimestamp(utente);
                            break;
                        case 2:
                            // Maiuscolo
                            utente = new DecoratorMaiuscolo(utente);
                            break;
                        case 3:
                            // Emoji
                            utente = new DecoratorEmoji(utente);
                            break;
                        case 4:
                            // Normale
                            break;
                        case 5:
                            // Tutti
                            utente = new DecoratorMaiuscolo(new DecoratorTimestamp(new DecoratorEmoji(utente)));
                            break;
                    
                        default:
                            // Tipo non valido
                            valid=false;
                            System.out.println("Scelta non valida");
                            break;
                    }
                    //controllo
                    if (valid) {
                        observer= (Observer) utente;
                        notificationManager.addObserver(observer);
                        utenti.add(utente);
                        //aggiunta utente alla map
                        Sessione.getInstance().login(utente);
                        System.out.println("Utente registrato con successo");
                    }
                   
                    break;
                case 2:
                    //login utente
                    System.out.println("Nome:");
                    String nomeLogin = stringScanner.nextLine();

                    System.out.println("Password:");
                    String passLogin = stringScanner.nextLine();
                    utente = null;
                    //controllo nome e password
                    for (Component u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeLogin) && u.getPassword().equals(passLogin)) {
                            utente = u;
                            break;
                        }
                    }
                    if (utente != null) {
                        Sessione.getInstance().login(utente);
                        System.out.println("Benvenuto " + utente.getNome());
                    }else{
                        System.out.println("Utente non trovato");
                    }
                    break;
                case 3:
                    //Invia notifica
                    //controllo sessione
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    System.out.println("Inserisci la notifica: ");
                    String messaggio = stringScanner.nextLine();
                    //invia notifica
                    notificationManager.inviaNotifica(messaggio);
                    break;
                case 4:
                    //Richiedi notifiche
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    //ottengo observer
                    observer = (Observer) Sessione.getInstance().getUtente();
                    if(observer != null){
                        notificationManager.addObserver(observer);
                        System.out.println("Notifiche richieste");
                    }
                    break;
                case 5:
                    //smetti di ricevere notifiche
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login"); 
                        break;
                    }
                    //ottengo observer
                    observer = (Observer) Sessione.getInstance().getUtente();
                    if(observer != null){
                        notificationManager.removeObserver(observer);
                        System.out.println("Hai disdetto le notifiche");
                    }
                    break;
                case 6:
                    //logout
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }else{
                        Sessione.getInstance().logout();
                    }
                    break;

                case 7:
                    //esci
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Scelta non valida"); 
                    break;   
                }
        }
    }
}

//Singleton sessione
class Sessione {
    //instanza
    private static Sessione instance;
    //utente loggato
    private Component utenteLoggato;
    //costruttore privato
    private Sessione() {}
    //metodo per ottenere istanza
    public static Sessione getInstance() {
        if (instance == null) {
            instance = new Sessione();
        }
        return instance;
    }
    //metodo per effettuare il login
    public void login(Component u) {
        if(u == null){
            System.out.println("Utente non esistente");
            return;
        }
        this.utenteLoggato = u;
    }
    //metodo per ottenere l'utente loggato
    public Component getUtente() {
        return utenteLoggato;
    }
    //metodo per effettuare il logout
    public void logout() {
        if (utenteLoggato != null) {
            System.out.println("Logout di " + utenteLoggato.getNome());
            utenteLoggato = null;
        } else {
            System.out.println("Nessun utente loggato!");
        }
    }
}
//interfaccia subject
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String messaggio);
}
//interfaccia observer
interface Observer {
    void update(String messaggio);
}

// Singleton NotificationManager
class NotificationManager implements Subject {
    //istanza
    private static NotificationManager instance;
    //lista degli utenti
    private List<Observer> observers = new ArrayList<>();
    //costruttore privato
    private NotificationManager() {}
    //metodo per ottenere istanza
    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }
    //metodo per aggiungere utente
    public void addObserver(Observer o) {
        observers.add(o);
    } 
    //metodo per rimuovere utente
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    //metodo per notificare utenti
    public void notifyObservers(String messaggio) {
        for (Observer o : observers) {
            o.update(messaggio);
        }
    }
    //invia notifica
    public void inviaNotifica(String messaggio) {
        notifyObservers(messaggio);
    }
}
//interfaccia component
interface Component{
    String modifyNotification(String messaggio);
    String getNome();
    String getPassword();
}

abstract class DecoratorUtente implements Component, Observer{
    //campo componente
    private Component component;
    public DecoratorUtente(Component component){
        this.component = component;
    }
    //override printNotification
    @Override
    public String modifyNotification(String messaggio) {
        return component.modifyNotification(messaggio);
    }
    //override update
    @Override
    public void update(String messaggio) {
        String text=modifyNotification(messaggio);
        System.out.println(text);
    }
    //override getNome
    @Override
    public String getNome() {
        return component.getNome();
    }
    //override getPassword
    @Override
    public String getPassword() {
        return component.getPassword();
    }
}
//Decorator concreto maiuscolo
class DecoratorMaiuscolo extends DecoratorUtente{
    //costruttore
    public DecoratorMaiuscolo(Component component){
        super(component);
    }
    //override modifyNotification
    @Override
    public String modifyNotification(String messaggio) {
        return super.modifyNotification(messaggio).toUpperCase();
    }
}
// Decorator concreto Timestamp
class DecoratorTimestamp extends DecoratorUtente{
    //costruttore
    public DecoratorTimestamp(Component component){
        super(component);
    }
    //override modifyNotification
    @Override
    public String modifyNotification(String messaggio) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String timestamp = now.format(formatter);

        return "[" + timestamp + "] " + super.modifyNotification(messaggio);
        }
}
//decorator emoji
class DecoratorEmoji extends DecoratorUtente{
    //costruttore
    public DecoratorEmoji(Component component){
        super(component);
    }
    //override modifyNotification
    @Override
    public String modifyNotification(String messaggio) {
        return super.modifyNotification(messaggio)+" :)";
    }
}

class Utente implements Observer, Component{
    //campo notifica
    private String password;
    private String nome;
    //costruttore
    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }
    //getter e setter
    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //override modifyNotification
    @Override
    public String modifyNotification(String messaggio) {
        return messaggio;
    }
    //override update
    @Override
    public void update(String messaggio) {
        String text=modifyNotification(messaggio);
        System.out.println(text);
    }

}

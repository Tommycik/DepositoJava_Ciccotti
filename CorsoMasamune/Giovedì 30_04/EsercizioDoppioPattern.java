import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioDoppioPattern {
    public static void main(String[] args) {
        //lista degli utenti
        ArrayList<Utente> utenti = new ArrayList<>();
        //creazione gestore notifiche
        GestoreNotifiche gestoreNotifiche = GestoreNotifiche.getInstance();
        //creazione utente
        Utente provaUtente =new Utente("Marco", "1234");
        utenti.add(provaUtente);
        // aggiungi observer
        gestoreNotifiche.addObserver(provaUtente);
        Utente provaUtente2 =new Utente("Mario", "1234");
        utenti.add(provaUtente2);
        // aggiungi observer
        gestoreNotifiche.addObserver(provaUtente2);
        //notifica gli observer
        gestoreNotifiche.notify("Messaggio di prova");
        //rimuovi observer
        gestoreNotifiche.removeObserver(provaUtente);
        System.out.println("Notifiche rimosse per " + provaUtente.getNome());
        //notifica gli observer
        gestoreNotifiche.notify("Messaggio di prova 2");
         Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        while(true){
            //menu
            System.out.println("\n1. Registrazione utente");
            System.out.println("2. Login");
            System.out.println("3. Pubblica notifica");
            System.out.println("4. Chiedi aggiornamenti");
            System.out.println("5. Ferma aggiornamenti");
            System.out.println("6. Logout");
            System.out.println("7. Esci");
            int scelta = intScanner.nextInt();
            Utente utente = null;
            //scelta utente
            switch (scelta){
                case 1:
                    //registrazione utente
                    System.out.println("Inserisci il tuo nome: ");
                    String nomeUtente = stringScanner.nextLine();
                    System.out.println("Inserisci la password: ");
                    String password = stringScanner.nextLine();
                    //controlla se nome già presente
                    for (Utente u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeUtente)) {
                            System.out.println("Utente già presente");
                            break;
                        }
                    }
                    utente = new Utente(nomeUtente, password);
                    utenti.add(utente);
                    Sessione.getInstance().login(utente);
                    break;
                case 2:
                    //login utente
                    System.out.println("Nome:");
                    String nomeLogin = stringScanner.nextLine();

                    System.out.println("Password:");
                    String passLogin = stringScanner.nextLine();
                    Utente utenteLogin = null;
                    //controllo nome e password
                    for (Utente u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeLogin) && u.getPassword().equals(passLogin)) {
                            utenteLogin = u;
                            break;
                        }
                    }
                    //controllo se utente trovato
                    if (utenteLogin != null) {
                        Sessione.getInstance().login(utenteLogin);
                        System.out.println("Benvenuto " + utenteLogin.getNome());
                    }else{
                        System.out.println("Utente non trovato");
                    }
                    break;
                case 3:
                    //pubblicazione notifica
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    System.out.println("Inserisci il tetso della notifica: ");
                    String notifica = stringScanner.nextLine();
                    gestoreNotifiche.notify(notifica);
                    break;
                case 4:
                    //richiedi notifiche
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    gestoreNotifiche.addObserver(Sessione.getInstance().getUtente());
                    System.out.println("Hai richiesto le notifiche");
                    break;
                case 5: 
                    //ferma notifiche  
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                     
                    gestoreNotifiche.removeObserver(Sessione.getInstance().getUtente());
                    System.out.println("Hai fermato le notifiche");
                    break;
                case 6:
                    //logout utente
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
                    //scelta non valida
                    System.out.println("Scelta non valida"); 
                    break;   
                }
        }
    }
}
//singleton gestione notifiche
class GestoreNotifiche implements Subject{
    //istanza
    private static GestoreNotifiche instance;
    //lista degli observer
    private List<Observer> observers = new ArrayList<>();
    //costruttore privato e getinstance
    private GestoreNotifiche(){}
    public static GestoreNotifiche getInstance(){
        if(instance == null){
            instance = new GestoreNotifiche();
        }
        return instance;
    }
    //aggiungi observer
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    //rimuovi observer
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    //notifica gli observer
    public void notifyObservers(String messaggio){
        for(Observer observer : observers){
            observer.update(messaggio);
        }
    }
    //pubblicazione notifica
    public void notify(String messaggio){
        notifyObservers(messaggio);
    }
}
//interfaccia observer
interface Observer{
    public void update(String messaggio);
}
//interfaccia subject
interface Subject{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(String messaggio);
}
class Utente implements Observer{
    private String nome;
    private String password;
    //costruttore
    public Utente(String nome, String password){
        this.nome = nome;
        this.password = password;
    }
    //metodo per ottenere il nome
    public String getNome(){
        return nome;
    }
    //metodo per ottenere la password
    public String getPassword(){
        return password;
    }
    //metodo per notificare gli observer
    @Override
    public void update(String messaggio) {
        System.out.println(nome + " ha ricevuto la notifica: " + messaggio);
    }
}

//Singleton sessione
class Sessione {
    //istanza
    private static Sessione instance;
    //utente loggato
    private Utente utenteLoggato;
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
    public void login(Utente u) {
        //controllo utente non nullo
        if(u == null){
            System.out.println("Utente non esistente");
            return;
        }
        this.utenteLoggato = u;
    }
    //metodo per ottenere l'utente loggato
    public Utente getUtente() {
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

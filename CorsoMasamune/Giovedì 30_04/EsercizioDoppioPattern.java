import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioDoppioPattern {
    public static void main(String[] args) {
        //lista degli utenti
        Arraylist<Utente> utenti = new ArrayList<>();
        //creazione gestore notifiche
        GestoreNotifiche gestoreNotifiche = GestoreNotifiche.getInstance();
        //creazione utente
        Utente provaUtente =new utente("Mario", "1234");
        utenti.add(provaUtente);
        // aggiungi observer
        gestoreNotifiche.addObserver(provaUtente);
        Utente provaUtente2 =new utente("Mario", "1234");
        utenti.add(provaUtente2);
        // aggiungi observer
        gestoreNotifiche.addObserver(provaUtente2);
        //notifica gli observer
        gestoreNotifiche.notify("Messaggio di prova");
        //rimuovi observer
        gestoreNotifiche.removeObserver(provaUtente);
        //notifica gli observer
        gestoreNotifiche.notify("Messaggio di prova 2");
         Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Registrazione utente");
            System.out.println("2. Login");
            System.out.println("3. Pubblica notifica");
            System.out.println("4. Chiedi aggiornamenti");
            System.out.println("5. Logout");
            System.out.println("6. Esci");
            int scelta = intScanner.nextInt();
            Utente utente = null;
            switch (scelta){
                case 1:
                    System.out.println("Inserisci il tuo nome: ");
                    String nomeUtente = stringScanner.nextLine();
                    System.out.println("Inserisci la password: ");
                    String password = stringScanner.nextLine();
                    //controlla doppioni
                    for (Utente u : utenti) {
                        if (u.getNome().equals(nomeUtente)) {
                            System.out.println("Utente già presente");
                            break;
                        }
                    }
                    utente = new Utente(nomeUtente, password);
                    utenti.add(utente);
                    Sessione.getInstance().login(utente);
                    break;
                case 2:
                    System.out.println("Nome:");
                    String nomeLogin = stringScanner.nextLine();

                    System.out.println("Password:");
                    String passLogin = stringScanner.nextLine();
                    Utente utenteLogin = null;
                    for (Utente u : utenti) {
                        if (u.getNome().equals(nomeLogin) && u.getPassword().equals(passLogin)) {
                            utenteLogin = u;
                            break;
                        }
                    }
                    if (utenteLogin != null) {
                        Sessione.getInstance().login(utenteLogin);
                        System.out.println("Benvenuto " + utenteLogin.getNome());
                    }else{
                        System.out.println("Utente non trovato");
                    }
                    break;
                case 3:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    System.out.println("Inserisci il tetso della notifica: ");
                    String notifica = stringScanner.nextLine();
                    gestoreNotifiche.notify(notifica);
                    break;
                case 4:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    gestoreNotifiche.addObserver(Sessione.getInstance().getUtente);
                    break;
                case 5:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }else{
                        Sessione.getInstance().logout();
                    }
                    break;

                case 6:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Scelta non valida"); 
                    break;   
                }
        }
    }
}
//singleton gestione notifiche
class GestoreNotifiche implements Subject{
    private static GestoreNotifiche instance;
    private List<Observer> observers = new ArrayList<>();
    //costruttore e getinstance
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
class utente implements Observer{
    private String nome;
    private String password;
    //costruttore
    public utente(String nome, String password){
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
    private static Sessione instance;
    private Utente utenteLoggato;

    private Sessione() {}

    public static Sessione getInstance() {
        if (instance == null) {
            instance = new Sessione();
        }
        return instance;
    }

    public void login(Utente u) {
        if(u == null){
            System.out.println("Utente non esistente");
            return;
        }
        this.utenteLoggato = u;
    }

    public Utente getUtente() {
        return utenteLoggato;
    }
    public void logout() {
        if (utenteLoggato != null) {
            System.out.println("Logout di " + utenteLoggato.getNome());
            utenteLoggato = null;
        } else {
            System.out.println("Nessun utente loggato!");
        }
    }
}

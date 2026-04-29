import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioDBManager {
    public static void main(String[] args) {
        //Proviamo a ottenere un Databasemanager
        Databasemanager databasemanager = Databasemanager.getInstance();
        databasemanager.connect();
        //Proviamo a ottenere un altro Databasemanager
        Databasemanager databasemanager2 = Databasemanager.getInstance();
        //Verifichiamo che sia lo stesso
        System.out.println("Sono lo stesso databasemanager: " + databasemanager.toString().equals(databasemanager2.toString()));
        databasemanager2.connect();
        //Controlliamo valore di coonectionCount
        System.out.println("Connessioni attive: " + databasemanager.getConnectionCount());
        //Otteniamo l'utente
        Utente utente = Utente.getInstance();
        //Scanners
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        while(true){
            //menu per inserire dato , cercare dato,rimuovere dato, visualizzare idati e uscire
            System.out.println("1. Inserire Dato");
            System.out.println("2. Cercare Dato");
            System.out.println("3. Rimuovere Dato");
            System.out.println("4. Visualizza Dati");
            System.out.println("5. Esci");
            int scelta = intScanner.nextInt();
            //Controllo scelta
            switch (scelta) {
                case 1:
                    //Inseriamo un dato
                    System.out.println("Inserisci un dato: ");
                    String dato = stringScanner.nextLine();
                    utente.inserisciDato(dato);
                    break;
                case 2:
                    //Cerchiamo un dato
                    System.out.println("Cerca un dato: ");
                    String dato2 = stringScanner.nextLine();
                    String risultato = utente.cercaDato(dato2);
                    break;
                case 3:
                    //Rimuoviamo un dato
                    System.out.println("Rimuovi un dato: ");
                    String dato3 = stringScanner.nextLine();
                    utente.rimuoviDato(dato3);
                    break;
                case 4:
                    //Visualizziamo tutti i dati
                    databasemanager.show();
                    break;
                case 5:
                    //Usciamo dal programma
                    System.out.println("Arrivederci!");
                    return;
                default:
                    //Scelta non valida
                    System.out.println("Scelta non valida");
            }
        }
    }
}
class Databasemanager {
    //instance
    private static Databasemanager instance;
    private int connectionCount = 0;
    private Database database;
    //costruttore privato
    private Databasemanager() {
        database = Database.getInstance();
    }
    //metodo per ottenere l'istanza
    public static Databasemanager getInstance() {
        if (instance == null) {
            instance = new Databasemanager();
        }
        return instance;
    }
    //metodo per ottenere un connessione
    public void connect() {
        connectionCount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
    }
    //metodo per chiudere una connessione
    public void close() {
        connectionCount--;
        System.out.println("Connessione chiusa. Connessioni attive: " + connectionCount);
    }
    //metodo per inserire un dato
    public void insert(String dato) {
        database.insert(dato);
    }
    //metodo per rimuovere un dato
    public void remove(String dato) {
        database.remove(dato);
    }
    //metodo per cercare un dato e stamparlo
    public String search(String dato) {
        return database.search(dato);
    }
    
    //metodo per visualizzare i dati
    public void show() {
        for (String dato : database.getDati()) {
            System.out.println(dato);
        }
    }
    // metodo per ottenere il numero di connessioni
    public int getConnectionCount() {
        return connectionCount;
    }
    
}

class Database{
    //instance
    private static Database instance;
    private ArrayList<String> dati = new ArrayList<String>();
    //costruttore privato
    private Database() {}
    //metodo per ottenere l'istanza
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    //getter
    public ArrayList<String> getDati(){
        return dati;
    }
    //metodo per inserire un dato controllando sia univoco
    public void insert(String dato) {
        if (!dati.contains(dato)) {
            dati.add(dato);
        }else{
            System.out.println("Dato già presente");
        }
    }
    //metodo per rimuovere un dato
    public void remove(String dato) {
        if (dati.contains(dato)) {
            dati.remove(dato);
        }else{
            System.out.println("Dato non presente");
        }
    }
    //metodo per cercare un dato e stamparlo
    public String search(String dato) {
        if (dati.contains(dato)) {
            System.out.println("Dato trovato");
            int index = dati.indexOf(dato);
            System.out.println("Indice: " + index + " Dato: " + dati.get(index));
            return dati.get(index);

        }else{
            System.out.println("Dato non trovato");
            return null;
        }
    }
}

class Utente {
    private static Utente utente;
    Databasemanager databasemanager;
    //costruttore privato
    private Utente() {
        databasemanager = Databasemanager.getInstance();
    }
    //metodo per ottenere l'istanza
    public static Utente getInstance() {
        if (utente == null) {
            utente = new Utente();
        }
        return utente;
    }
    //metodo per inserire un dato
    public void inserisciDato(String dato) {
        databasemanager.insert(dato);
    }
    //metodo per rimuovere un dato
    public void rimuoviDato(String dato) {
        databasemanager.remove(dato);
    }
    //metodo per cercare un dato
    public String cercaDato(String dato) {
        return databasemanager.search(dato);
    }
}

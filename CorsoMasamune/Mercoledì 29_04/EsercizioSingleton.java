
import java.util.Date;
import java.util.Scanner;

public class EsercizioSingleton {
    public static void main(String[] args) {
        //Proviamo a creare un logger
        Logger logger = Logger.getInstance();
        //Scriviamo dei messaggi
        logger.scriviMessaggio("Messaggio di esempio");
        logger.scriviMessaggio("Messaggio di esempio parte 2");
        //Proviamo a creare un altro logger
        Logger logger2 = Logger.getInstance();
        logger2.scriviMessaggio("Messaggio di esempio parte 3");
        //verifichiamo che il logger sia lo stesso usando il riferimento
        System.out.println("Sono lo stesso logger: " + logger.toString().equals(logger2.toString()));
        //Proviamo a ottenere  l'utente
        UtenteProva utente = UtenteProva.getInstance();
        UtenteProva utente2 = UtenteProva.getInstance();
        //Facciamo la stessa prova
        System.out.println("Sono lo stesso utente: " + utente.toString().equals(utente2.toString()));
        //Fai scrivere messaggi all'utente
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scrivi un messaggio o stop per smettere : ");
            String messaggio = scanner.nextLine();
            //Controlliamo se è stop
            if (messaggio.equalsIgnoreCase("stop")) {
                System.out.println("Smettiamo");
                return;
            }
            //Scriviamo il messaggio dell'utente
            utente.scriviMessaggio(messaggio);
        }
    }   
}

class Logger {
    // Instance
    private static Logger instance;
    //costruttore privato
    private Logger() {}
    //metodo per ottenere l'istanza
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    //metodo per scrivere il messaggio
    public void scriviMessaggio(String messaggio) {
        System.out.println("Messaggio: " + messaggio + " Data e ora: " + new Date());
    }
}
//utente singleton
class UtenteProva {
    // Instance
    private static UtenteProva instance;
    private Logger logger;
    //costruttore privato
    private UtenteProva() {
        logger = Logger.getInstance();
    }
    //metodo per ottenere l'istanza
    public static UtenteProva getInstance() {
        if (instance == null) {
            instance = new UtenteProva();
        }
        return instance;
    }
    //metodo per scrivere il messaggio
    public void scriviMessaggio(String messaggio) {
        logger.scriviMessaggio(messaggio);
    }
}
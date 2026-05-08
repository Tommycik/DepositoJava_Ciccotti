import java.util.Scanner;
import java.util.ArrayList;
public class GestoreTicketController {
    private GestoreTicketFacade gestore;
    private GestoreTicketView view;
    private Context context;
    ArrayList<UtenteSistema> utenti;

    public GestoreTicketController() {
        this.gestore = new GestoreTicketFacade();
        this.view = new GestoreTicketView();
        this.utenti = new ArrayList<UtenteSistema>();
    }

    //stampa menu
    public void stampaMenu() {
        if(context != null) {
            context.stampaMenu();
        }else {
            view.menuUtentiNonLoggato();
        }
    }

    //esegui azione menu
    public boolean eseguiAzioneMenu(int scelta) {
        if(context != null) {
            return context.eseguiAzioneMenu(scelta, view, gestore);
        }else {
            Scanner stringScanner = new Scanner(System.in);
            switch(scelta) {
                case 1:
                    //login
                    System.out.println("Inserisci username:");
                    String username = stringScanner.nextLine();
                    System.out.println("Inserisci password:");
                    String password = stringScanner.nextLine();
                    for(UtenteSistema utente : utenti) {
                        if(utente.getNome().equalsIgnoreCase(username) && utente.getPassword().equalsIgnoreCase(password)) {
                            if(utente.isAdmin()) {
                                context.setStrategy(new StrategyAdmin());
                            }else {
                                context.setStrategy(new StrategyUtente());
                            }
                            view.stampaMessaggio("Login effettuato con successo");
                            break;
                        }
                        }
                        view.stampaMessaggio("Utente non trovato");
                        break;
                    case 2:
                        //registrazione
                        System.out.println("Inserisci username:");
                        username = stringScanner.nextLine();
                        System.out.println("Inserisci password:");
                        password = stringScanner.nextLine();
                        System.out.println("Inserisci nome:");
                        String nome = stringScanner.nextLine();
                        //utente o admin
                        System.out.println("Inserisci admin (1) o utente (2):");
                        int sceltaAdmin = stringScanner.nextInt();
                        UtenteSistema utente = null;
                        if(sceltaAdmin == 1) {
                            utente = new Admin(nome, password);
                            utenti.add(utente);
                            view.stampaMessaggio("Utente creato con successo");
                            gestore.addObserver(utente);
                            gestore.login(utente);
                        }else if(sceltaAdmin == 2) {
                            utente = new UtenteSistema(nome, password);
                            utenti.add(utente);
                            view.stampaMessaggio("Utente creato con successo");
                            gestore.addObserver(utente);
                            gestore.login(utente);
                            view.stampaMessaggio("Utente creato con successo");
                        }else {
                            view.stampaMessaggio("Scelta non valida");
                        }
                    case 3:
                        //esci
                        view.stampaMessaggio("Esci dal programma");
                        return false;
                    default:
                        view.stampaMessaggio("Scelta non valida");
                    }
                    return true;
                    
        }
    }


}

    

import java.util.Scanner;

public class StrategyNonLoggato implements StrategyMenu{

    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiNonLoggato();
    }
    @Override
    public boolean eseguiAzioneMenu(int scelta,GestoreTicketController gestore) {
        Scanner stringScanner = new Scanner(System.in);
            switch(scelta) {
                case 1:
                    //login
                    System.out.println("Inserisci username:");
                    String username = stringScanner.nextLine();
                    System.out.println("Inserisci password:");
                    String password = stringScanner.nextLine();
                    for(UtenteSistema utente : gestore.getUtenti()) {
                        if(utente.getNome().equalsIgnoreCase(username) && utente.getPassword().equalsIgnoreCase(password)) {
                            if(utente.isAdmin()) {
                                gestore.getContext().setStrategy(new StrategyAdmin());
                            }else {
                                gestore.getContext().setStrategy(new StrategyUtente());
                            }
                            gestore.getView().stampaMessaggio("Login effettuato con successo");
                            break;
                        }
                        }
                        gestore.getView().stampaMessaggio("Utente non trovato");
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
                            gestore.getUtenti().add(utente);
                            gestore.getView().stampaMessaggio("Utente creato con successo");
                            gestore.getGestore().addObserver(utente);
                            gestore.getGestore().login(utente);
                        }else if(sceltaAdmin == 2) {
                            utente = new UtenteSistema(nome, password);
                            gestore.getUtenti().add(utente);
                            gestore.getView().stampaMessaggio("Utente creato con successo");
                            gestore.getGestore().addObserver(utente);
                            gestore.getGestore().login(utente);
                            gestore.getView().stampaMessaggio("Utente creato con successo");
                        }else {
                            gestore.getView().stampaMessaggio("Scelta non valida");
                        }
                    case 3:
                        //esci
                        gestore.getView().stampaMessaggio("Esci dal programma");
                        return false;
                    default:
                        gestore.getView().stampaMessaggio("Scelta non valida");
                    }
                    return true;
    }
    
}

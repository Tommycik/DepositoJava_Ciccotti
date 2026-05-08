package Controller;
import java.util.Scanner;
import View.GestoreTicketView;
import Model.UtenteSistema;
import Model.Admin;
//classe strategia concreta utentenon loggato
public class StrategyMenuNonLoggato implements StrategyMenu{
    //helper aggiunta utente
    private void aggiungiUtente(UtenteSistema utente, GestoreTicketController controller) {
        controller.getUtenti().add(utente);
        controller.getGestore().addObserver(utente);
        controller.getSessione().login(utente);
        controller.stampaMessaggio("Utente creato con successo: " + utente.getDescrizioneCompleta());
    }

    //helper registrazione utente
    private void registraUtente(GestoreTicketController controller) {
        //registrazione

        //input utente
        Scanner stringScanner = new Scanner(System.in);
        controller.stampaMessaggio("Inserisci nome:");
        String nome = stringScanner.nextLine();
        controller.stampaMessaggio("Inserisci password:");
        String password = stringScanner.nextLine();

        //utente o admin
        controller.stampaMessaggio("Inserisci admin (1) o utente (2):");
        int sceltaAdmin = stringScanner.nextInt();
        UtenteSistema utente = null;
        //controllo se nome già in uso
        for(UtenteSistema u : controller.getUtenti()) {
            if(u.getNome().equalsIgnoreCase(nome)) {
                controller.stampaMessaggio("Nome già in uso");
                break;
            }
        }
        //utente o admin
        if(sceltaAdmin == 1) {
            utente = new Admin(nome, password);
            //aggiungo utente
            aggiungiUtente(utente, controller);
            //cambio strategia
            controller.setStrategy(new StrategyMenuAdmin());
        }else if(sceltaAdmin == 2) {
            utente = new UtenteSistema(nome, password);
            aggiungiUtente(utente, controller);
            controller.setStrategy(new StrategyMenuUtenteNormale());
        }else {
            controller.stampaMessaggio("Scelta non valida");
        }
    }

    //helper Login utente
    private void loginUtente(GestoreTicketController controller) {
        //scanner
        Scanner stringScanner = new Scanner(System.in);
        //login
        controller.stampaMessaggio("Inserisci username:");
        String username = stringScanner.nextLine();
        controller.stampaMessaggio("Inserisci password:");
        String password = stringScanner.nextLine();
        //controllo utente
        for(UtenteSistema utente : controller.getUtenti()) {
            if(utente.getNome().equalsIgnoreCase(username) && utente.verificaPassword(password)) {
                //se admin
                if(utente.isAdmin()) {
                    controller.setStrategy(new StrategyMenuAdmin());
                }else { 
                    //altrimenti utente
                    controller.setStrategy(new StrategyMenuUtenteNormale());
                }
                //login utente
                controller.getSessione().login(utente);
                //login effettuato
                controller.stampaMessaggio("Login effettuato con successo: " + utente.getDescrizioneCompleta());
                break;
            }
        }
        controller.stampaMessaggio("Utente non trovato");
    }

    //metodo per stampare menu
    @Override
    public void stampaMenu(GestoreTicketView view) {
        view.menuUtentiNonLoggato();
    }

    //metodo per eseguire azione menu
    @Override
    public boolean eseguiAzioneMenu(int scelta,GestoreTicketController controller) {
        //scanner
        Scanner stringScanner = new Scanner(System.in);
        switch(scelta) {
            case 1:
                //login
                loginUtente(controller);
                break;
            case 2:
                //registrazione
                registraUtente(controller);
                break;
            case 3:
                //esci
                controller.stampaMessaggio("Esci dal programma");
                return false;
            default:
                //scelta non valida
                controller.stampaMessaggio("Scelta non valida");
            }
        return true;
    }
    
}

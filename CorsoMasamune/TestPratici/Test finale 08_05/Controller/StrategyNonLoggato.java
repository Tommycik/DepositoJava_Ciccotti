package Controller;
import java.util.Scanner;
import View.GestoreTicketView;
import Model.UtenteSistema;
import Model.Admin;
//classe strategia concreta utentenon loggato
public class StrategyNonLoggato implements StrategyMenu{
    //helper aggiunta utente
    private void aggiungiUtente(UtenteSistema utente, GestoreTicketController controller) {
        controller.getUtenti().add(utente);
        controller.getGestore().addObserver(utente);
        controller.getGestore().login(utente);
        controller.getView().stampaMessaggio("Utente creato con successo: " + utente.getDescrizioneCompleta());
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
                controller.getView().stampaMessaggio("Inserisci username:");
                String username = stringScanner.nextLine();
                controller.getView().stampaMessaggio("Inserisci password:");
                String password = stringScanner.nextLine();
                //controllo utente
                for(UtenteSistema utente : controller.getUtenti()) {
                    if(utente.getNome().equalsIgnoreCase(username) && utente.verificaPassword(password)) {
                        //se admin
                        if(utente.isAdmin()) {
                            controller.setStrategy(new StrategyAdmin());
                        }else { 
                            //altrimenti utente
                            controller.setStrategy(new StrategyUtente());
                        }
                        //login utente
                        controller.getGestore().login(utente);
                        //login effettuato
                        controller.getView().stampaMessaggio("Login effettuato con successo: " + utente.getDescrizioneCompleta());
                        break;
                    }
                    }
                    controller.getView().stampaMessaggio("Utente non trovato");
                    break;
            case 2:
                //registrazione
                //input utente
                controller.getView().stampaMessaggio("Inserisci nome:");
                String nome = stringScanner.nextLine();
                controller.getView().stampaMessaggio("Inserisci password:");
                password = stringScanner.nextLine();

                //utente o admin
                controller.getView().stampaMessaggio("Inserisci admin (1) o utente (2):");
                int sceltaAdmin = stringScanner.nextInt();
                UtenteSistema utente = null;
                //controllo nome già in uso
                for(UtenteSistema u : controller.getUtenti()) {
                    if(u.getNome().equalsIgnoreCase(nome)) {
                        controller.getView().stampaMessaggio("Nome già in uso");
                        break;
                    }
                }

                //utente o admin
                if(sceltaAdmin == 1) {
                    utente = new Admin(nome, password);
                    //aggiungo utente
                    aggiungiUtente(utente, controller);
                    //cambio strategia
                    controller.setStrategy(new StrategyAdmin());
                }else if(sceltaAdmin == 2) {
                    utente = new UtenteSistema(nome, password);
                    aggiungiUtente(utente, controller);
                    controller.setStrategy(new StrategyUtente());
                }else {
                    controller.getView().stampaMessaggio("Scelta non valida");
                }
                break;
            case 3:
                //esci
                controller.getView().stampaMessaggio("Esci dal programma");
                return false;
            default:
                //scelta non valida
                controller.getView().stampaMessaggio("Scelta non valida");
            }
        return true;
    }
    
}

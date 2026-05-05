package EsercizioFabbricaMVC.Controller;

import EsercizioFabbricaMVC.Model.Utente;
import EsercizioFabbricaMVC.View.UtenteView;
//classe UtenteController
public class UtenteController {
    //Istanza privata
    private static UtenteController instance;
    private Utente utente;
    private UtenteView view;
    //costruttore privato
    private UtenteController(Utente utente, UtenteView view) {
        this.utente = utente;
        this.view = view;
    }
    //metodo per ottenere istanza
    public static UtenteController getInstance(Utente utente, UtenteView view) {
        if (instance == null) {
            instance = new UtenteController(utente, view);
        }
        return instance;
    }
    //metodo per ottenere l'utente
    public Utente getUtente() {
        return utente;
    }
    //metodo login
    public void login(Utente utente) {
        this.utente = utente;
        view.login();
        mostraUtente();
    }
    //metodo logout
    public void logout() {
        this.utente = null;
        view.logout();
    }
    //metodo per mostrare il messaggio di benvenuto
    public void mostraMessaggioBenvenuto() {
        view.messaggioBenvenuto();
    }
    //metodo per mostrare il nome dell'utente
    public void mostraUtente() {
        view.mostraUtente(utente.getNome());
    }
    //metodo per mostrare il menu
    public void mostraMenu() {
        view.mostraMenu();
    }
}

package Model;
import java.util.ArrayList;
//facade per gestire sessione utente
public class SessioneFacade {
    
    //singleton
    private SessioneUtenteSistema sessione;
    //costruttore
    public SessioneFacade() {
        sessione = SessioneUtenteSistema.getInstance();
    }
    //login
    public boolean login(UtenteSistema utente) {
        return sessione.login(utente);
    }
    //logout
    public boolean logout() {
        return sessione.logout();
    }
    //verifica login
    public boolean isLogged() {
        return sessione.isLogged();
    }
    //verifica utente
    public UtenteSistema getUtente() {
        return sessione.getUtente();
    }
    //isAdmin
    public boolean isAdmin() {
        return sessione.isAdmin();
    }
    //ottenere notifiche
    public ArrayList<String> getNotifiche() {
        return sessione.getUtente().getNotifiche();
    }
    //cancellazione notifiche
    public void cancellaNotifiche(){
        sessione.getUtente().cancellaNotifiche();
    }
    
}

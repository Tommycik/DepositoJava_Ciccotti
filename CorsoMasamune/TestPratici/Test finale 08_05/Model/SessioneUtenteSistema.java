package Model;
//singleton sessione UtenteSistema
public class SessioneUtenteSistema {
    //instance
    private static SessioneUtenteSistema instance;
    //utente
    private UtenteSistema utente;
    //costruttore
    private SessioneUtenteSistema() {
        utente = null;
    }
    //metodo getInstance
    public static SessioneUtenteSistema getInstance() {
        if (instance == null) {
            instance = new SessioneUtenteSistema();
        }
        return instance;
    }
    //metodo getUtente
    public UtenteSistema getUtente() {
        return utente;
    }
    //metodo setUtente
    public void setUtente(UtenteSistema utente) {
        this.utente = utente;
    }
    //Controlla se admin
    public boolean isAdmin() {
        return utente != null && utente.isAdmin();
    }
    //metodo isLogged
    public boolean isLogged() {
        return utente != null;
    }
    //metodo logout
    public boolean logout() {
        utente = null;
        return true;
    }
    //metodo login
    public boolean login(UtenteSistema utente) {
        if (utente == null) {
            return false;
        }
        this.utente = utente;
        return true;
    }
    
}

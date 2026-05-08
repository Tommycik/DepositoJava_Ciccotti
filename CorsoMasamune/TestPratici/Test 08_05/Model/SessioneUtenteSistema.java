//singleton sessione
public class Sessione {
    private static Sessione instance;
    private Utente utente;
    //costruttore
    private Sessione() {
        utente = null;
    }
    //metodo getInstance
    public static Sessione getInstance() {
        if (instance == null) {
            instance = new Sessione();
        }
        return instance;
    }
    //metodo getUtente
    public Utente getUtente() {
        return utente;
    }
    //metodo setUtente
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    //Controlla se admin
    public boolean isAdmin() {
        return utente.getClass().equals(Admin.class);
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
    public boolean login(Utente utente) {
        if (utente == null) {
            return false;
        }
        this.utente = utente;
        return true;
    }
    
}

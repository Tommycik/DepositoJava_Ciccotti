package Model;
//singleton sessione UtenteSistema
class SessioneUtenteSistema {
    //instance
    private static SessioneUtenteSistema instance;
    //utente
    private UtenteSistema utente;
    //costruttore
    private SessioneUtenteSistema() {
        utente = null;
    }
    //metodo getInstance
    static SessioneUtenteSistema getInstance() {
        if (instance == null) {
            instance = new SessioneUtenteSistema();
        }
        return instance;
    }
    //metodo getUtente
    UtenteSistema getUtente() {
        return utente;
    }
    //metodo setUtente
    void setUtente(UtenteSistema utente) {
        this.utente = utente;
    }
    //Controlla se admin
    boolean isAdmin() {
        return utente != null && utente.isAdmin();
    }
    //metodo isLogged
    boolean isLogged() {
        return utente != null;
    }
    //metodo logout
    boolean logout() {
        utente = null;
        return true;
    }
    //metodo login
    boolean login(UtenteSistema utente) {
        if (utente == null) {
            return false;
        }
        this.utente = utente;
        return true;
    }
    
}

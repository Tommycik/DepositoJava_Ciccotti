package Model;
import java.util.ArrayList;

public class UtenteSistema implements ObserverNotifiche {
    private String nome;
    private String password;
    //Collezione di notifiche
    protected ArrayList<String> notifiche;
    //costruttore
    public UtenteSistema(String nome, String password) {
        this.nome = nome;
        this.password = password;
        notifiche = new ArrayList<String>();
    }

    //getter
    public String getNome() {
        return nome;
    }
    
    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    //metodo notifica
    @Override
    public void update(String messaggio) {
        notifiche.add(messaggio);
    }

    //metodo per ottenere notifiche
    public ArrayList<String> getNotifiche() {
        return notifiche;
    }
    //cancellazione notifiche
    public void cancellaNotifiche() {
        notifiche.clear();
    }
    //metodo verifica password
    public boolean verificaPassword(String password) {
        return this.password.equals(password);
    }
    //descrizione completa
    public String getDescrizioneCompleta() {
        return "Nome: " + nome;
    }
    //metodo isAdmin
    public boolean isAdmin() {
        return false;
    }
}

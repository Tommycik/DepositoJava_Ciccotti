import java.util.ArrayList;

public class Utente implements ObserverNotifiche {
    private String nome;
    private String password;
    //Collezione di notifiche
    protected ArrayList<String> notifiche;
    //costruttore
    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
        notifiche = new ArrayList<String>();
    }

    //getter
    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
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

    //metodo getNotifiche concatenate
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
    public String descrizioneCompleta() {
        return "Nome: " + nome;
    }
}

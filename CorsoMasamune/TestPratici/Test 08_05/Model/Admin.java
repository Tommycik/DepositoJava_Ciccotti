public class Admin extends Utente {
    //costruttore
    public Admin(String nome, String password) {
        super(nome, password);
    }
    //override metodo descrizioneCompleta
    @Override
    public String descrizioneCompleta() {
        return super.descrizioneCompleta() + " Status: amministratore";
    }
    
}

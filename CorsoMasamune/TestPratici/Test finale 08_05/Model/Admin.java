package Model;
//classe admin
public class Admin extends UtenteSistema {
    //costruttore
    public Admin(String nome, String password) {
        super(nome, password);
    }
    //override metodo descrizioneCompleta
    @Override
    public String getDescrizioneCompleta() {
        return super.getDescrizioneCompleta() + " Status: amministratore";
    }
    //override metodo isAdmin
    @Override
    public boolean isAdmin() {
        return true;
    }
    
}

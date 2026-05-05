package EsercizioFabbricaMVC.View;
//classe UtenteView
public class UtenteView {
    //metodo per mostrare il messaggio di benvenuto
    public void messaggioBenvenuto() {
        System.out.println("Creazione utente");
    }
    //metodo per mostrare il nome dell'utente
    public void mostraUtente(String nome) {
        System.out.println("Utente corrente: " + nome);
    }
    //metodo login
    public void login() {
        System.out.println("Login effettuato");
    }
    //metodo logout
    public void logout() {
        System.out.println("Logout effettuato");
    }
    //metodo per mostrare il menu
    public void mostraMenu() {
        System.out.println("\nMENU: ");
        System.out.println("1. Crea Veicolo");
        System.out.println("2. Mostra storico");
        System.out.println("3. Login");
        System.out.println("4. Logout");
        System.out.println("5. Esci");
    }
}

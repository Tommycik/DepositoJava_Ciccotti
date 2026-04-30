import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EsercizioMedioObserver {
    public static void main(String[] args) {
        //creazione agenzia borsa
        AgenziaBorsa agenziaBorsa = new AgenziaBorsa();
        
        //aggiungi investitori bancari  
        agenziaBorsa.addInvestitore(new UtenteBancario("Mario", "1234"));
        agenziaBorsa.addInvestitore(new UtenteBancario("Mario", "1234"));
        // aggiungi investitori privati
        agenziaBorsa.addInvestitore(new UtentePrivato("Mario", "1234"));
        agenziaBorsa.addInvestitore(new UtentePrivato("Mario", "1234"));
        
        //notifica gli investitori
        agenziaBorsa.notificaInvestitori("Investimento", 1000);
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        List<Utente> utenti = new ArrayList<>();
        while(true){
            System.out.println("\n1. Registrazione utente");
            System.out.println("2. Login");
            System.out.println("3. Aggiorna azione");
            System.out.println("4. Investi");
            System.out.println("5. Logout");
            System.out.println("6. Esci");
            int scelta = intScanner.nextInt();
            Utente utente = null;
            switch (scelta){
                case 1:
                    System.out.println("Inserisci il tuo nome: ");
                    String nomeUtente = stringScanner.nextLine();
                    System.out.println("Inserisci la password: ");
                    String password = stringScanner.nextLine();
                    System.out.println("Tipo: 1=Privato, 2=Bancario");
                    int tipo = intScanner.nextInt();
                    //controlla doppioni
                    for (Utente u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeUtente)) {
                            System.out.println("Utente già presente");
                            break;
                        }
                    }
                    if(tipo == 1){
                        utente = new UtentePrivato(nomeUtente, password);
                       
                    }else if(tipo == 2){
                        utente = new UtenteBancario(nomeUtente, password);
                    }
                    utenti.add(utente);
                    Sessione.getInstance().login(utente);
                    break;
                case 2:
                    System.out.println("Nome:");
                    String nomeLogin = stringScanner.nextLine();

                    System.out.println("Password:");
                    String passLogin = stringScanner.nextLine();
                    Utente utenteLogin = null;
                    for (Utente u : utenti) {
                        if (u.getNome().equalsIgnoreCase(nomeLogin) && u.getPassword().equals(passLogin)) {
                            utenteLogin = u;
                            break;
                        }
                    }
                    if (utenteLogin != null) {
                        Sessione.getInstance().login(utenteLogin);
                        System.out.println("Benvenuto " + utenteLogin.getNome());
                    }else{
                        System.out.println("Utente non trovato");
                    }
                    break;
                case 3:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    System.out.println("Inserisci il nome dell'azione: ");
                    String azione = stringScanner.nextLine();
                    System.out.println("Inserisci il nuovo valore dell'azione: ");
                    double valore = doubleScanner.nextDouble();
                    agenziaBorsa.aggiornaValoreAzione(azione, valore);
                    break;
                case 4:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    agenziaBorsa.addInvestitore(Sessione.getInstance().getUtente());
                    System.out.println("Hai investito!");
                    break;
                case 5:
                    if(Sessione.getInstance().getUtente() == null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }else{
                        Sessione.getInstance().logout();
                    }
                    break;

                case 6:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Scelta non valida"); 
                    break;   
                }
        }
    }
}
// interfaccia investitore
interface Investitore{
    void notifica(String azione, double valore);
}
//subject
class AgenziaBorsa{
    //lista degli investitori
    private List<Investitore> investitori = new ArrayList<>();
    //aggiungi investitore
    public void addInvestitore(Investitore investitore){
        investitori.add(investitore);
    }
    //rimuovi investitore
    public void removeInvestitore(Investitore investitore){
        investitori.remove(investitore);
    }
    //notifica gli investitori
    public void notificaInvestitori(String azione, double valore){
        for (Investitore investitore : investitori) {
            investitore.notifica(azione, valore);
        }
    }
    public void aggiornaValoreAzione(String nome, double valore){
        if(valore >= 0){
            notificaInvestitori(nome, valore);
        }else{
            System.out.println("Non puoi avere un valore negativo");
        }
    }
}

class UtentePrivato extends Utente {

    public UtentePrivato(String nome, String password) {
        super(nome, password);
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println(nome + " (Privato): azione " + azione + " = " + valore);
    }
}
abstract class Utente implements Investitore {
    protected String nome;
    protected String password;

    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
     @Override
    public void notifica(String azione, double valore) {
        System.out.println(nome + " ha ricevuto aggiornamento: " + azione + " = " + valore);
    }
}

class UtenteBancario extends Utente{

    public UtenteBancario(String nome, String password) {
        super(nome, password);
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println(nome + " (Banca) avvisa cliente -> " + azione + " = " + valore);
    }
}

//Singleton sessione
class Sessione {
    private static Sessione instance;
    private Utente utenteLoggato;

    private Sessione() {}

    public static Sessione getInstance() {
        if (instance == null) {
            instance = new Sessione();
        }
        return instance;
    }

    public void login(Utente u) {
        if(u == null){
            System.out.println("Utente non esistente");
            return;
        }
        this.utenteLoggato = u;
    }

    public Utente getUtente() {
        return utenteLoggato;
    }
    public void logout() {
        if (utenteLoggato != null) {
            System.out.println("Logout di " + utenteLoggato.getNome());
            utenteLoggato = null;
        } else {
            System.out.println("Nessun utente loggato!");
        }
    }
}




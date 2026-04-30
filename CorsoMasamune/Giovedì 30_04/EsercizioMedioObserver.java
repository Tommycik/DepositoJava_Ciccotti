import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EsercizioMedioObserver {
    public static void main(String[] args) {
        //creazione utente
        Utente utente = Utente.getInstance("Tommy");
        //aggiungi investitori privati
        utente.addInvestitore(new InvestitorePrivato());
        utente.addInvestitore(new InvestitorePrivato());
        //aggiungi investitori bancari
        utente.addInvestitore(new InvestitoreBancario());
        utente.addInvestitore(new InvestitoreBancario());
        Scanner StringScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        while(true){
            System.out.println("Ciao " + utente.getNome() + ", cosa vuole fare?");
            //chiedi se vuole uscire o cambiare valore di una azione
            System.out.println("Vuoi cambiare valore di una azione? [s/n]");
            String risposta = StringScanner.nextLine();
            if(risposta.equalsIgnoreCase("s")){
                System.out.println("Inserisci il nome dell'azione: ");
                String azione = StringScanner.nextLine();
                System.out.println("Inserisci il nuovo valore dell'azione: ");
                double valore = doubleScanner.nextDouble();
                utente.aggiornaValoreAzione(azione, valore);
            }else if(risposta.equalsIgnoreCase("n")){
                System.out.println("Arrivederci!");
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
// implementazione investitore
class InvestitorePrivato implements Investitore{
    //override notifica
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("La mia azione: " + azione + " ha un nuovo valore: " + valore);
    }
}
//implementazione investitore
class InvestitoreBancario implements Investitore{
    //override notifica
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Devo avvertire il cliente che l'azione: " + azione + " ha un nuovo valore: " + valore);
    }
}

//Singleton utente
class Utente{
    private static Utente instance;
    private String nome;
    private AgenziaBorsa agenzia;
    //costruttore
    private Utente(String nome){
        this.nome = nome;
        agenzia = new AgenziaBorsa();
        agenzia.addInvestitore(new InvestitorePrivato());
        agenzia.addInvestitore(new InvestitoreBancario());
    }
    //getInstance
    public static Utente getInstance(String nome){
        if(instance == null){
            instance = new Utente(nome);
        }
        return instance;
    }
    //getter e setter
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    //aggiorna valore azione
    public void aggiornaValoreAzione(String azione, double valore){
        agenzia.aggiornaValoreAzione(nome, valore);
    }
    //aggiungi investitore
    public void addInvestitore(Investitore investitore){
        agenzia.addInvestitore(investitore);
    }
    //rimuovi investitore
    public void removeInvestitore(Investitore investitore){
        agenzia.removeInvestitore(investitore);
    }
}




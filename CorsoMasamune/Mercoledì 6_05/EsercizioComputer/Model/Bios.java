package EsercizioComputer.Model;

public class Bios implements StrategyComponente {
    //metodo per inizializzare il componente
    @Deprecated
    public String Inizializza() {
        return "Inizializzazione BIOS";
    }

    //metodo per caricare il componente
    @Override
    public String carica() {
        return "Caricamento BIOS";
    }
    //metodo per avviare il componente
    @Override
    public String avvia() {
        return "Avvio BIOS";
    }
    
}

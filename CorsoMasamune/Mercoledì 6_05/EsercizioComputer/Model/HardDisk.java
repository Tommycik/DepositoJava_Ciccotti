package EsercizioComputer.Model;

public class HardDisk implements StrategyComponente {
    //metodo per inizializzare il componente
    @Override
    public String Inizializza() {
        return "Inizializzazione HardDisk";
    }
    //metodo per caricare il componente
    @Override
    public String carica() {
        return "Caricamento HardDisk";
    }
    //metodo per avviare il componente
    @Override
    public String avvia() {
        return "Avvio HardDisk";
    }
    
}

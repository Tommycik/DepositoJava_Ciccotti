package EsercizioComputer.Model;
//Classe Context , strategy per componenti
public class Context {
    private StrategyComponente strategy;

    public void setStrategy(StrategyComponente strategy) {
        this.strategy = strategy;
    }
    //metodo per inizializzare il componente
    public String inizializza() {
        return strategy.Inizializza();
    }
    //metodo per caricare il componente
    public String carica() {
        return strategy.carica();
    }
    //metodo per avviare il componente
    public String avvia() {
        return strategy.avvia();
    }
}

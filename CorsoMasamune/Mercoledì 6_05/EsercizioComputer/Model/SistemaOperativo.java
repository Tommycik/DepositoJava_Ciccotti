package EsercizioComputer.Model;

public class SistemaOperativo implements StrategyComponente {
    private StrategySistemaOperativo strategy;
    
    public void setStrategy(StrategySistemaOperativo strategy) {
        this.strategy = strategy;
    }

    public String Inizializza() {
        String messaggio = "Avvio Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }
        return messaggio;
    }
    public String carica() {
        String messaggio = "Caricamento Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }
        return messaggio;
    }
    public String avvia() {
        String messaggio = "Avvio Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }        
        return messaggio;
    }

    
}

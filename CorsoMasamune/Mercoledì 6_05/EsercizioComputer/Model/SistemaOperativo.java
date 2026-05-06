package EsercizioComputer.Model;
//Classe SistemaOperativo, usa strategy per scelta sistema operativo
public class SistemaOperativo implements StrategyComponente {
    private StrategySistemaOperativo strategy;
    
    public void setStrategy(StrategySistemaOperativo strategy) {
        this.strategy = strategy;
    }
    //metodo per inizializzare il componente
    @Override
    public String Inizializza() {
        String messaggio = "Avvio Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }
        return messaggio;
    }
    //metodo per caricare il componente
    @Override
    public String carica() {
        String messaggio = "Caricamento Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }
        return messaggio;
    }
    //metodo per avviare il componente
    @Override
    public String avvia() {
        String messaggio = "Avvio Sistema Operativo";
        if(strategy != null){
            messaggio = strategy.modifica(messaggio);
        }        
        return messaggio;
    }

    
}

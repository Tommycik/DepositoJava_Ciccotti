public class Context {
    
    private StrategyMenu strategy;
    
    public void setStrategy(StrategyMenu strategy) {
        this.strategy = strategy;
    }    
    public void stampaMenu() {
        strategy.stampaMenu();
    }
    public void eseguiAzioneMenu(int scelta) {
        strategy.eseguiAzioneMenu(scelta);
    }
    
}

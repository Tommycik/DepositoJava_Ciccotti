package Controller;

import View.GestoreTicketView;
//classe context utente
class ContextUtente {
    //strategia concreta
    private StrategyMenu strategy;
    //metodo per settare la strategia
    void setStrategy(StrategyMenu strategy) {
        this.strategy = strategy;
    }  
    //metodo per ottenere la strategia
    StrategyMenu getStrategy() {
        return strategy;
    }
    //metodo per stampare menu
    void stampaMenu(GestoreTicketView view) {
        if(strategy == null) {
            strategy = new StrategyMenuNonLoggato();
        }
        strategy.stampaMenu(view);
    }
    //metodo per eseguire azione menu
    boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        if (strategy == null) {
            strategy = new StrategyMenuNonLoggato();
        }
        return strategy.eseguiAzioneMenu(scelta, controller);
    }
    
}

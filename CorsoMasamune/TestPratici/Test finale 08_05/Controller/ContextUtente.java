package Controller;

import View.GestoreTicketView;
//classe context utente
public class ContextUtente {
    //strategia concreta
    private StrategyMenu strategy;
    //metodo per settare la strategia
    public void setStrategy(StrategyMenu strategy) {
        this.strategy = strategy;
    }  
    //metodo per ottenere la strategia
    public StrategyMenu getStrategy() {
        return strategy;
    }
    //metodo per stampare menu
    public void stampaMenu(GestoreTicketView view) {
        strategy.stampaMenu(view);
    }
    //metodo per eseguire azione menu
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller) {
        return strategy.eseguiAzioneMenu(scelta, controller);
    }
    
}

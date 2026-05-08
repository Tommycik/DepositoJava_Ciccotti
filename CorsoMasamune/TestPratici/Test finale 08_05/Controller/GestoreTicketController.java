package Controller;

import java.util.ArrayList;
import Model.UtenteSistema;
import Model.GestoreTicketFacade;
import View.GestoreTicketView;
//classe controller gestore ticket
public class GestoreTicketController {

    private GestoreTicketFacade gestore;
    private GestoreTicketView view;
    private ContextUtente context;
    //utenti
    ArrayList<UtenteSistema> utenti;

    //costruttore
    public GestoreTicketController() {
        this.gestore = new GestoreTicketFacade();
        this.view = new GestoreTicketView();
        this.utenti = new ArrayList<UtenteSistema>();
        this.context = new ContextUtente();
        this.context.setStrategy(new StrategyNonLoggato());
    }
    //getter
    public ArrayList<UtenteSistema> getUtenti() {
        return utenti;
    }
    public GestoreTicketFacade getGestore() {
        return gestore;
    }
    public GestoreTicketView getView() {
        return view;
    }
    public void setStrategy(StrategyMenu strategy) {
        this.context.setStrategy(strategy);
    }
    //stampa menu
    public void stampaMenu() {
        //controlo se non è loggato o strategia non impostata
        if(context.getStrategy() == null || (!gestore.isLogged())) {
            context.setStrategy(new StrategyNonLoggato());
        }
            context.stampaMenu(view);
    }

    //esegui azione menu
    public boolean eseguiAzioneMenu(int scelta) {
        //controlo se non è loggato o strategia non impostata
        if(context.getStrategy() == null || (!gestore.isLogged())) {
            context.setStrategy(new StrategyNonLoggato());
        }
        return context.eseguiAzioneMenu(scelta, this);
    }


}

    

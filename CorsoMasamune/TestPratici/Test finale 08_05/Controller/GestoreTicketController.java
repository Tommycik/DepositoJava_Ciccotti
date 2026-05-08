package Controller;

import java.util.ArrayList;
import Model.UtenteSistema;
import Model.GestoreTicketFacade;
import View.GestoreTicketView;
import Model.SessioneFacade;
import java.util.InputMismatchException;

//classe controller gestore ticket
public class GestoreTicketController {

    //facade model
    private GestoreTicketFacade gestore;
    private SessioneFacade sessione;
    //view
    private GestoreTicketView view;
    //context
    private ContextUtente context;
    //utenti
    private ArrayList<UtenteSistema> utenti;

    //costruttore
    public GestoreTicketController() {
        this.gestore = new GestoreTicketFacade();
        this.sessione = new SessioneFacade();
        this.view = new GestoreTicketView();
        this.utenti = new ArrayList<UtenteSistema>();
        this.context = new ContextUtente();
        this.context.setStrategy(new StrategyMenuNonLoggato());
    }

    //getter
    public SessioneFacade getSessione() {
        return sessione;
    }
    public ArrayList<UtenteSistema> getUtenti() {
        return utenti;
    }
    public GestoreTicketFacade getGestore() {
        return gestore;
    }
    public GestoreTicketView getView() {
        return view;
    }
    public ContextUtente getContext() {
        return context;
    }
    
    //setter
    public void setStrategy(StrategyMenu strategy) {
        this.context.setStrategy(strategy);
    }
    //stampa menu
    public void stampaMenu() {
        //controlo se non è loggato o strategia non impostata
        if(context.getStrategy() == null || (!sessione.isLogged())) {
            context.setStrategy(new StrategyMenuNonLoggato());
        }
            context.stampaMenu(view);
    }

    //esegui azione menu
    public boolean eseguiAzioneMenu(int scelta) {
        //controllo errore inserimento non valido
        boolean continua = true;
        try {
            //controlo se non è loggato o strategia non impostata
            if(context.getStrategy() == null || (!sessione.isLogged())) {
                context.setStrategy(new StrategyMenuNonLoggato());
            }
            continua = context.eseguiAzioneMenu(scelta, this);
        }catch(InputMismatchException e) {
            //inserimento non valido
            stampaMessaggio("Inserimento non valido, ritorno al menu");
        }catch(Exception e) {
            //errore imprevisto
            stampaMessaggio("Errore imprevisto, stop al programma");
            continua = false;
        }  
        return continua;
    }
    //mostra messaggio
    public void stampaMessaggio(String messaggio) {
        view.stampaMessaggio(messaggio);
    }
}




    

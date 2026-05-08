import java.util.Scanner;
import java.util.ArrayList;
public class GestoreTicketController {
    private GestoreTicketFacade gestore;
    private GestoreTicketView view;
    private Context context;
    ArrayList<UtenteSistema> utenti;


    public GestoreTicketController() {
        this.gestore = new GestoreTicketFacade();
        this.view = new GestoreTicketView();
        this.utenti = new ArrayList<UtenteSistema>();
        this.context = new Context();
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
    public Context getContext() {
        return context;
    }
    //stampa menu
    public void stampaMenu() {
        if(context != null) {
            context.stampaMenu();
        }else {
            view.menuUtentiNonLoggato();
        }
    }

    //esegui azione menu
    public boolean eseguiAzioneMenu(int scelta) {
        if(context != null) {
            return context.eseguiAzioneMenu(scelta, view, gestore);
        }else {
            return false;
        }
    }


}

    

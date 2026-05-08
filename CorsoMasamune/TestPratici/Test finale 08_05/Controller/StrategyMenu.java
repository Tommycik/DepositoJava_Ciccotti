package Controller;
import View.GestoreTicketView;
//interfaccia strategia menu
public interface StrategyMenu {
    //metodo per stampare menu
    public void stampaMenu(GestoreTicketView view);
    //metodo per eseguire azione menu
    public boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller);
}

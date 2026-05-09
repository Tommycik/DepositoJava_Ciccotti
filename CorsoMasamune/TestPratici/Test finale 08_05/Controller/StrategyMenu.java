package Controller;
import View.GestoreTicketView;
//interfaccia strategia menu
interface StrategyMenu {
    //metodo per stampare menu
    void stampaMenu(GestoreTicketView view);
    //metodo per eseguire azione menu
    boolean eseguiAzioneMenu(int scelta, GestoreTicketController controller);
}

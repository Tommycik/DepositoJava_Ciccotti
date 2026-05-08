//esercizio finale
import java.util.Scanner;
import Controller.GestoreTicketController;
import Controller.StrategyMenuNonLoggato;
public class EsercizioFinale {  
    //main
    public static void main(String[] args) {
        //Gestore sistema
        GestoreTicketController gestore = new GestoreTicketController(); 
        //Scanner
        Scanner intScanner = new Scanner(System.in);
        //Strategy non loggato
        gestore.setStrategy(new StrategyMenuNonLoggato());
        //Scelta non valida di default
        int scelta = -1;
        do {
            //stampa menu
            gestore.stampaMenu();
            scelta = intScanner.nextInt();
            //esecuzione azione menu
        }while(gestore.eseguiAzioneMenu(scelta));
       
    }
    
}

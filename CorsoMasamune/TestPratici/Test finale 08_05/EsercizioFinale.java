//esercizio finale
import java.util.Scanner;
import Controller.GestoreTicketController;
import Controller.StrategyMenuNonLoggato;
import java.util.InputMismatchException;
public class EsercizioFinale {  
    //main
    public static void main(String[] args) {
        //Gestore sistema
        GestoreTicketController controller = new GestoreTicketController(); 
        //Scanner
        Scanner intScanner = new Scanner(System.in);
        //Strategy non loggato
        controller.setStrategy(new StrategyMenuNonLoggato());
        //Scelta non valida di default
        int scelta = -1;
        //se continuare il ciclo o no
        boolean continua = true;
        do {
            //stampa menu
            controller.stampaMenu();
            try {
                scelta = intScanner.nextInt();
            }catch(InputMismatchException e) {
                //inserimento non valido
                controller.stampaMessaggio("Inserimento non valido");
                //pulisce la riga
                intScanner.next();
                continue;
            }catch(Exception e) {
                //errore imprevisto
                controller.stampaMessaggio("Errore imprevisto, stop al programma");
                return;
            }
            //esecuzione azione menu se scelta non produce errore
            continua = controller.eseguiAzioneMenu(scelta);
        }while(continua);  
    }
}

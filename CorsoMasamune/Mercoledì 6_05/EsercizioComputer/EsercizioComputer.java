package EsercizioComputer;

import java.util.Scanner;
import EsercizioComputer.Controller.ControllerPc;
import EsercizioComputer.Model.ComputerFacade;
import EsercizioComputer.View.ComputerView;
public class EsercizioComputer {
    public static void main(String[] args) {
        //Creazione delle classi
        ComputerView view = new ComputerView();
        ComputerFacade computerFacade = new ComputerFacade();
        ControllerPc controllerPc = new ControllerPc(view, computerFacade);
        //Scanners 
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        //ciclo while e menu per far scegliere all'utente
        boolean continueLoop = true;
        while (continueLoop) {
            controllerPc.mostraMenùComputer();
            int scelta = intScanner.nextInt();
            switch (scelta) {
                case 1 :
                    //accendi il computer
                    controllerPc.accendiComputer();
                    break;
                case 2 :
                    //cambia sistema operativo
                    controllerPc.mostraSceltaOperativo();
                    String sistema = stringScanner.nextLine();
                    controllerPc.cambiaOperativo(sistema);
                    break;
                case 3 :
                    //esci
                    System.out.println("Arrivederci");
                    continueLoop = false;
                    break;
                default :
                    //scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}

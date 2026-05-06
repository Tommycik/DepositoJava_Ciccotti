package EsercizioComputer.Controller;
import EsercizioComputer.Model.ComputerFacade;
import EsercizioComputer.View.ComputerView;
public class ControllerPc {
    private ComputerFacade computerFacade;
    private ComputerView view;
    //costruttore
    public ControllerPc(ComputerView view, ComputerFacade computerFacade) {
        this.view = view;
        this.computerFacade = computerFacade;
    }
    //metodo per l'accensione del computer
    public void accendiComputer() {
        String log = computerFacade.AccendiComputer();
        view.mostraAccensionentoComputer(log);
    }
    //metodo per cambiare sistema operativo
    public void cambiaOperativo(String sistema) {
        if(computerFacade.CambiaOperativo(sistema)){
            view.mostraMessaggio("Sistema operativo cambiato in " + sistema);
        }else{
            view.mostraMessaggio("Sistema operativo non valido");
        }
    }
    //metodo per la visone del menu
    public void mostraMenùComputer() {
        view.mostraMenùComputer();
    }
    //metodo per il menu dei sistemi operativi
    public void mostraSceltaOperativo() {
        view.mostraSceltaOperativo();
    }
}

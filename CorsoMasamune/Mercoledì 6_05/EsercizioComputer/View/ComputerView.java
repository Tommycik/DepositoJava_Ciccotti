package EsercizioComputer.View;

public class ComputerView {
    //metodo per mostrare il menu
    public void mostraMenùComputer() {
        System.out.println("1. Accendi il computer");
        System.out.println("2. Cambia sistema operativo");
        System.out.println("3. Esci");
    }
    //metodo per mostrare l'accensione del computer
    public void mostraAccensionentoComputer(String log) {
        System.out.println(log);
        System.out.println("Accensione completata");
    }
    //metodo per mostrare la scelta del sistema operativo
    public void mostraSceltaOperativo() {
        System.out.println("Scelta del sistema operativo");
        System.out.println("- Linux");
        System.out.println("- Windows");
    }
    //metodo per mostrare messaggi
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }   
}

package EsercizioComputer.Model;

public class ComputerFacade {
    //componenti
    private Bios bios = new Bios();
    private HardDisk hardDisk = new HardDisk();
    private SistemaOperativo sistemaOperativo = new SistemaOperativo();
    //contesto strategy
    private Context context = new Context();

    //metodo per accendere il computer
    public String AccendiComputer() {
        String messaggio = "";
        context.setStrategy(bios);
        messaggio = context.inizializza();
        messaggio += "\n";
        messaggio += context.carica();
        messaggio += "\n";        
        messaggio += context.avvia();
        context.setStrategy(hardDisk);
        messaggio += "\n";
        messaggio += context.inizializza();
        messaggio += "\n";
        messaggio += context.carica();
        messaggio += "\n";
        messaggio += context.avvia();
        context.setStrategy(sistemaOperativo);
        messaggio += "\n";
        messaggio += context.inizializza();
        messaggio += "\n";
        messaggio += context.carica();
        messaggio += "\n";
        messaggio += context.avvia();
        return messaggio;
    }
    //metodo per cambiare sistema operativo
    public boolean CambiaOperativo(String sistema) {
        if(sistema.equalsIgnoreCase("linux")){
            sistemaOperativo.setStrategy(new ConcreteStrategyLinux());
        }else if(sistema.equalsIgnoreCase("Windows")){
            sistemaOperativo.setStrategy(new ConcreteStrategyWindows());
        }else{
            sistemaOperativo.setStrategy(null);
            return false;
        }
        return true;
    }

}


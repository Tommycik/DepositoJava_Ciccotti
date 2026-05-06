package EsercizioComputer.Model;

public class ComputerFacade {
    //componenti
    private Bios bios = new Bios();
    private HardDisk hardDisk = new HardDisk();
    private SistemaOperativo sistemaOperativo = new SistemaOperativo();
    //contesto strategy
    private Context context = new Context();
    //costruttore
    public ComputerFacade() {
        sistemaOperativo.setStrategy(new ConcreteStrategyWindows());
    }
    //helper per accendere componente
    private String accendiComponente(StrategyComponente componente) {
        context.setStrategy(componente);
        String messaggio =context.inizializza();
        messaggio += "\n";
        messaggio += context.carica();
        messaggio += "\n";
        messaggio += context.avvia();
        return messaggio;
    }
    //metodo per accendere il computer
    public String AccendiComputer() {
        String messaggio = accendiComponente(bios);
        messaggio += "\n";
        messaggio += accendiComponente(hardDisk);
        messaggio += "\n";
        messaggio += accendiComponente(sistemaOperativo);
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


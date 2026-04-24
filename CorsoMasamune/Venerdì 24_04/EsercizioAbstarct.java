import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EsercizioAbstarct {
     public static void main(String[] args) {
        //Creazione scanners
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Scanner floatScanner = new Scanner(System.in);
        //Creazione manager
        ConsegnaManager manager = new ConsegnaManager();

        while (true) {
            //Menu
            System.out.println("1. Aggiungi Furgone");
            System.out.println("2. Aggiungi Drone");
            System.out.println("3. Lista veicoli");
            System.out.println("4. Esegui consegna");
            System.out.println("5. Traccia consegna");
            System.out.println("6. Esci");

            int scelta = intScanner.nextInt();
            // controllo scelta
            switch (scelta) {

                case 1:
                    System.out.println("Targa:");
                    String t1 = stringScanner.nextLine();
                    System.out.println("Carico massimo:");
                    float c1 = floatScanner.nextFloat();
                    //inserimento oggetto
                    manager.aggiungiVeicolo(new Furgone(t1, c1));
                    break;

                case 2:
                    System.out.println("Targa:");
                    String t2 = stringScanner.nextLine();
                    System.out.println("Carico massimo:");
                    float c2 = floatScanner.nextFloat();
                    //inserimento oggetto
                    manager.aggiungiVeicolo(new Drone(t2, c2));
                    break;

                case 3:
                    //mostra la lista dei veicoli
                    manager.listaVeicoli();
                    break;
                case 4:
                    // Scegli detsinazione
                    System.out.println("Scegli destinazione:");
                    String destinazione = stringScanner.nextLine();
                    // Inserisci peso del pacco
                    System.out.println("Scegli peso pacco:");
                    int pesoPacco = intScanner.nextInt();
                    //mostra i veicoli
                    manager.listaVeicoli();
                    // Scegli il veicolo
                    System.out.println("Scegli veicolo tramite targa:");
                    String targa = stringScanner.nextLine();
                    String codice = manager.consegnaPacco(targa, pesoPacco, destinazione);
                    if (codice!= null) {
                        System.out.println("Consegna affidata con successo con codice: " + codice);
                    }else{
                        System.out.println("Errore nella consegna");
                    }
                    break;
                case 5:
                    //traccia la consegna
                    System.out.println("Scegli codice di consegna:");
                    String codiceConsegna = stringScanner.nextLine();
                    manager.tracciaConsegna(codiceConsegna);
                    break;
                case 6:
                    //Esci dal programma
                    System.out.println("Arrivederci!");
                    return;
            }
        }
    }
}

abstract class VeicoloConsegna{
    private String targa;
    private float caricoMassimo;
    private String codiceConsegna = null;
    abstract public String consegnaPacco(String destinazione,int pesoPacco);
    //costruttore
    public VeicoloConsegna(String targa, float caricoMassimo){
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }
    //getter e setter
    public String getTarga(){
        return targa;
    }
    public void setTarga(String targa){
        this.targa = targa;
    }
    public String getCodiceConsegna(){
        return codiceConsegna;
    }
    public void setCodiceConsegna(String codiceConsegna){
        this.codiceConsegna = codiceConsegna;
    }
    public float getCaricoMassimo(){
        return caricoMassimo;
    }
    public void setCaricoMassimo(float caricoMassimo){
        if(caricoMassimo > 0){
            this.caricoMassimo = caricoMassimo;
        }else{
            System.out.println("Il carico massimo non può essere negativo");
        }
    }
    public void stampaInfo(){
        System.out.println("Targa veicolo: "+targa +" Carico massimo: "+caricoMassimo);
    }
}
interface Tracciabile{
    public void tracciaConsegna(String codiceTracking);
} 

class Furgone extends VeicoloConsegna implements Tracciabile{
    public Furgone(String targa, float caricoMassimo){
        super(targa, caricoMassimo);
    }
    @Override
    public String consegnaPacco(String destinazione, int pesoPacco){
        if(pesoPacco > getCaricoMassimo()){
            System.out.println("Non puoi consegnare più di "+getCaricoMassimo()+" kg, carico troppo pesante");
            return null;
        }
        System.out.println("Consegna pacco via strada a "+destinazione + " con targa "+getTarga());
        //codice di consegna
        String codice = String.valueOf(new Random().nextInt(10000));
        setCodiceConsegna(codice);
        return codice;
    }
    @Override
    public void tracciaConsegna(String codiceTracking){
        System.out.println("Consegna in corso via strada con codice: "+codiceTracking);
    }
}

class Drone extends VeicoloConsegna implements Tracciabile{
    public Drone(String targa, float caricoMassimo){
        super(targa, caricoMassimo);
    }
    @Override
    public String consegnaPacco(String destinazione,int pesoPacco){
        if(pesoPacco > getCaricoMassimo()){
            System.out.println("Non puoi consegnare più di "+getCaricoMassimo()+" kg, carico troppo pesante");
            return null;
        }
        System.out.println("Consegna pacco via aria a "+destinazione + " con targa "+getTarga());
        //codice di consegna
        String codice = String.valueOf(new Random().nextInt(10000));
        tracciaConsegna(String.valueOf(codice));
        setCodiceConsegna(codice);
        return codice;
    }
    @Override
    public void tracciaConsegna(String codiceTracking){
        System.out.println("Consegna in corso via aria con codice: "+codiceTracking);
    }
}

class ConsegnaManager {
    private ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();

    public void aggiungiVeicolo(VeicoloConsegna v) {
        //Controla non ci siano veicoli con stessa targa
        for (VeicoloConsegna v1 : veicoli) {
            if (v1.getTarga().equals(v.getTarga())) {
                System.out.println("Non puoi aggiungere un veicolo con la stessa targa");
                return;
            }
        }
        veicoli.add(v);
    }

    public void listaVeicoli() {
        System.out.println("Veicoli presenti:");
        //Stampa tutti i veicoli
        for (VeicoloConsegna v : veicoli) {
            v.stampaInfo();
        }
    }
    public String consegnaPacco(String targa, int pesoPacco, String destinazione) {
        //Controlla se il veicolo è presente
        for (VeicoloConsegna veicolo : veicoli) {
            if (veicolo.getTarga().equals(targa)) {
                return veicolo.consegnaPacco(destinazione, pesoPacco);
            }
        }
        System.out.println("Non esiste alcun veicolo con la targa " + targa);
        return null;
    }

    public void  tracciaConsegna( String codice) {
        //Controlla se il veicolo è presente
        for (VeicoloConsegna veicolo : veicoli) {
            if (veicolo.getCodiceConsegna().equals(codice)) {
                if(veicolo instanceof Tracciabile t){
                    ((Tracciabile)veicolo).tracciaConsegna(codice);
                    return;
                }
                
            }
        }
        System.out.println("Non esiste alcun veicolo con il codice di consegna " + codice);
    }
}

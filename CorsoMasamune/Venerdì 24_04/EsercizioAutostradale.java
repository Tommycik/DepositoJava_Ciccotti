import java.util.ArrayList;
import java.util.Scanner;
public class EsercizioAutostradale {
     public static void main(String[] args) {

        //Scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        //Veicoli
        ArrayList<Veicolo> veicoli = new ArrayList<>();

        while (true) {
            //Scelta opzioni
            System.out.println("1. Aggiungi Auto");
            System.out.println("2. Aggiungi Camion");
            System.out.println("3. Aggiungi Moto");
            System.out.println("4. Visualizza pedaggi");
            System.out.println("5. Visualizza informazioni veicoli");
            System.out.println("6. Esci");

            int scelta = intScanner.nextInt();

            String targa;
            int velocita;
            int assi;
            //Controllo scelta
            switch (scelta) {

                case 1:
                    System.out.println("Targa:");
                    targa = stringScanner.nextLine();

                    System.out.println("Velocità:");
                    velocita = intScanner.nextInt();

                    System.out.println("Assi:");
                    assi = intScanner.nextInt();

                    System.out.println("Potenza:");
                    int potenza = intScanner.nextInt();
                    //Aggiungi veicolo
                    veicoli.add(new Auto(velocita,targa,assi,potenza));
                    break;

                case 2:
                    System.out.println("Targa:");
                    targa = stringScanner.nextLine();

                    System.out.println("Velocità:");
                    velocita = intScanner.nextInt();

                    System.out.println("Assi:");
                    assi = intScanner.nextInt();

                    System.out.println("Cilindrata:");
                    int cilindrata = intScanner.nextInt();
                    //Aggiungi veicolo
                    veicoli.add(new Camion(velocita, targa, assi, cilindrata));
                    break;

                case 3:
                    System.out.println("Targa:");
                    targa = stringScanner.nextLine();

                    System.out.println("Velocità:");
                    velocita = intScanner.nextInt();

                    System.out.println("Assi:");
                    assi = intScanner.nextInt();

                    System.out.println("Peso:");
                    int peso = intScanner.nextInt();
                    //Aggiungi veicolo
                    veicoli.add(new Moto(velocita, targa, assi, peso));
                    break;

                case 4:
                    System.out.println("Pedaggi:");
                    //Stampa i pedaggi
                    for (Veicolo veicolo : veicoli) {
                        System.out.println("Veicolo con targa " + veicolo.getTarga() + " ha come pedaggio: " + veicolo.calcolaPedaggio());
                    }
                    break;
                case 5:
                    System.out.println("Veicoli: ");
                    //Stampa informazioni dei veicoli
                    for (Veicolo veicolo : veicoli) {
                        veicolo.stampaInfo();
                    }
                    break;
                case 6:
                    //Esce dal programma
                    System.out.println("Arrivederci!");
                    return;

                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
    
}

abstract class Veicolo{
    private int velocita;
    private String targa;
    private int numeroAssi;
    //Costruttore
    public Veicolo(int velocita, String targa, int numeroAssi){
        this.velocita = velocita;
        this.targa = targa;
        this.numeroAssi = numeroAssi;
    }

     //Metodo astratto
    abstract public double calcolaPedaggio();

    //getter e setter
    public int getVelocita(){
        return velocita;
    }
    public void setVelocita(int velocita){
        //controllo velocità
        if (velocita >=0) {
            this.velocita = velocita;
            
        }else{
            System.out.println("La velocità non può essere negativa");
        }
    }
    public String getTarga(){
        return targa;
    }
    public void setTarga(String targa){
        this.targa = targa;
    }
    public int getNumeroAssi(){
        return numeroAssi;
    }
    public void setNumeroAssi(int numeroAssi){
        //Controllo numero di assi
        if(numeroAssi > 0){
            this.numeroAssi = numeroAssi;
        }else{
            System.out.println("Non puoi avere un numero di assi negativo");
        }
    }

    public void stampaInfo(){
        System.out.println("Veicolo "+getNumeroAssi()+" con targa "+getTarga()+" e velocità "+getVelocita());
    }
}

class Auto extends Veicolo{
    private int potenza;
    public Auto(int velocita, String targa, int numeroAssi, int potenza){
        super(velocita, targa, numeroAssi);
        this.potenza = potenza;
    }

    //getter e setter
    public int getPotenza(){
        return potenza;
    }
    public void setPotenza(int potenza){
        if(potenza > 0){
            this.potenza = potenza;
        }else{
            System.out.println("La potenza non può essere negativa o uguale a 0");
        }
    }
    //Override metodo astratto
    @Override
    public double calcolaPedaggio(){
        return getNumeroAssi()*potenza;
    }
    @Override
    public void stampaInfo(){
        System.out.println("Veicolo "+getNumeroAssi()+" con targa "+getTarga()+" e velocità "+getVelocita()+" e potenza "+getPotenza());
    }
}

class Camion extends Veicolo{
    private int cilindrata;
    //Costruttore
    public Camion(int velocita, String targa, int numeroAssi, int cilindrata){
        super(velocita, targa, numeroAssi);
        this.cilindrata = cilindrata;
    }
    //getter e setter
    public int getCilindrata(){
        return cilindrata;
    }
    public void setCilindrata(int cilindrata){
        //controllo cilindrata
        if(cilindrata > 0){
            this.cilindrata = cilindrata;
        }else{
            System.out.println("La cilindrata non può essere negativa o uguale a 0");
        }
    }
    //Override metodo astratto
    @Override
    public double calcolaPedaggio(){
        return getNumeroAssi() +cilindrata*2;
    }
    @Override
    public void stampaInfo(){
        System.out.println("Veicolo "+getNumeroAssi()+" con targa "+getTarga()+" e velocità "+getVelocita()+" e cilindrata "+getCilindrata());
    }
}

class Moto extends Veicolo{
    private int peso;
    //Costruttore
    public Moto(int velocita, String targa, int numeroAssi, int peso){
        super(velocita, targa, numeroAssi);
        this.peso = peso;
    }
    //getter e setter
    public int getPeso(){
        return peso;
    }
    public void setPeso(int peso){
        //Controllo peso
        if(peso > 0){
            this.peso = peso;
        }else{
            System.out.println("Il peso non può essere negativo o uguale a 0");
        }
    }
    //Override metodo astratto
    @Override
    public double calcolaPedaggio(){
        return getNumeroAssi() + getPeso();
    }
    @Override
    public void stampaInfo(){
        System.out.println("Veicolo "+getNumeroAssi()+" con targa "+getTarga()+" e velocità "+getVelocita()+" e peso "+getPeso());
    }
}

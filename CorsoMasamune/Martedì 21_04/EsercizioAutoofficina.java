import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioAutoofficina {

    //ciclo chiede utente cosa vuole fare
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Officina officina = new Officina();
        boolean continueLoop = true;
        while (continueLoop) {
            //menu
            System.out.println("1. Aggiungi un auto");
            System.out.println("2. Visualizza tutte le auto");
            System.out.println("3. Esci");
            int scelta = intScanner.nextInt();
            String marca;
            String targa;
            switch (scelta) {
                case 1:
                    //inserisci auto
                    System.out.println("Inserisci il nome della marca:");
                    marca = stringScanner.nextLine();
                    System.out.println("Inserisci la targa:");
                    targa = stringScanner.nextLine();
                    Auto auto = new Auto(marca, targa);
                    officina.addAuto(auto);
                    break;
                case 2:
                    //visualizza tutte le auto
                    officina.display();
                    break;
                case 3:
                    //esci
                    System.out.println("Arrivederci");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}

class Auto {
    private String marca;
    private String targa;

    //Costruttore
    public Auto(String marca, String targa) {
        this.marca = marca;
        this.targa = targa;
    }

    //override metodo toString
    @Override
    public String toString() {
        return "Auto [marca=" + marca + ", targa=" + targa + "]";
    }

    //override metodo equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Auto)) return false;
        Auto other = (Auto) obj;
        return marca.equals(other.marca) &&
        targa.equals(other.targa);
    }

    //override metodo hashCode
    @Override
    public int hashCode() {
        int result = 31 * marca.hashCode();
        result += 31 * targa.hashCode();
        return result;
    }
    
}

class Officina{
    private ArrayList<Auto> auto_o;

    //costruttore
    public Officina() {
        auto_o = new ArrayList<>();
    }

    //metodo per aggiungere un auto
    public void addAuto(Auto auto) {
        //controlla se l'auto esiste gia'
        for (Auto auto2 : auto_o) {
            if (auto.equals(auto2)) {
                System.out.println("Auto già presente");
                return;
            }
        }
        auto_o.add(auto);
    }

    public void display() {
        for (Auto auto : auto_o) {
            System.out.println(auto);
        }
    }

}



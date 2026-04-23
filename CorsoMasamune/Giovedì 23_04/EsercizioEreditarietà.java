import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioEreditarietà {
    public static void main(String[] args) {
        //Crea lista di animali
        ArrayList<Animale> animali = new ArrayList<Animale>();
        //Aggiunge gli animali
        animali.add(new Cane("Cane", 3));
        animali.add(new Gatto("Gatto", 5));
        //Stampa gli animali
        for (Animale animale : animali) {
            animale.stampa();
            animale.faiVerso();
        }

        //Crea zoo e fa decidere all'utente cosa fare con gli animali
        Zoo zoo = new Zoo();
        //Scanner per le scelte
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        boolean esci = false;
        //Ciclo while
        while (!esci) {
            //Menu
            System.out.println("Che cosa vuoi fare?");
            System.out.println("1. Aggiungi un animale");
            System.out.println("2. Stampa gli animali");
            System.out.println("3. Esci");
            int scelta = intScanner.nextInt();
            switch (scelta) {
                case 1:
                    //Scelta animale
                    System.out.println("Quale animale vuoi aggiungere?");
                    System.out.println("1. Uccello");
                    System.out.println("2. Cane");
                    System.out.println("3. Gatto");
                    int animale = intScanner.nextInt();
                    switch (animale) {
                        case 1:
                            //Aggiungi uccello
                            System.out.println("Nome dell'uccello: ");
                            String nome = stringScanner.next();
                            System.out.println("Età dell'uccello: ");
                            int età = intScanner.nextInt();
                            zoo.aggiungiAnimale(new Uccello(nome, età));
                            break;
                        case 2:
                            //Aggiungi cane
                            System.out.println("Nome del cane: ");
                            String nomeCane = stringScanner.next();
                            System.out.println("Età del cane: ");
                            int etàCane = intScanner.nextInt();
                            zoo.aggiungiAnimale(new Cane(nomeCane, etàCane));
                            break;
                        case 3:
                            //Aggiungi gatto
                            System.out.println("Nome del gatto: ");
                            String nomeGatto = stringScanner.next();
                            System.out.println("Età del gatto: ");
                            int etàGatto = intScanner.nextInt();
                            zoo.aggiungiAnimale(new Gatto(nomeGatto, etàGatto));
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            break;
                    }
                    
                    break;
                case 2:
                    //Stampa gli animali
                    zoo.stampaAnimali();
                    break;
                case 3:
                    //Esci
                    System.out.println("Uscita dall'applicazione");
                    esci = true;
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}

class Animale {
    protected String nome;
    protected int età;

    public Animale() {
        nome = "No name";
        età = 0;
    }
    public Animale(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }
    
    public void faiVerso() {
        System.out.println("Verso generico");
    }
    public void stampa() {
        System.out.println("nome: " + nome + " età: " + età);
    }
}

class Cane extends Animale {
    public Cane() {
        super();
    }
    public Cane(String nome, int età) {
        super(nome, età);
    }
    
    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

class Gatto extends Animale {
    public Gatto() {
        super();
    }
    public Gatto(String nome, int età) {
        super(nome, età);
    }
    
    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}
class Uccello extends Animale {
    public Uccello() {
        super();
    }
    public Uccello(String nome, int età) {
        super(nome, età);
    }
    
    @Override
    public void faiVerso() {
        System.out.println("Cra!");
    }
}

//vai a creare una classe zoo con dentro almeno 3 tipi di animali divisi in liste diverse riempite dall’utente
class Zoo {
    ArrayList<Uccello> uccelli = new ArrayList<Uccello>();
    ArrayList<Cane> cani = new ArrayList<Cane>();
    ArrayList<Gatto> gatti = new ArrayList<Gatto>();
    
    public Zoo() {}

    //Aggiunge un animale alla lista di animali
    public void aggiungiAnimale(Animale animale) {
        if (animale instanceof Uccello) {
            uccelli.add((Uccello) animale);
        } else if (animale instanceof Cane) {
            cani.add((Cane) animale);
        } else if (animale instanceof Gatto) {
            gatti.add((Gatto) animale);
        }else{
            System.out.println("Animale non valido");
        }
    }

    //Stampa tutti gli animali e fa il loro verso
    public void stampaAnimali() {
        System.out.println("Uccelli:");
        for (Animale animale : uccelli) {
            animale.stampa();
            animale.faiVerso();
        }
        System.out.println("Cani:");
        for (Animale animale : cani) {
            animale.stampa();
            animale.faiVerso();
        }
        System.out.println("Gatti:");
        for (Animale animale : gatti) {
            animale.stampa();
            animale.faiVerso();
        }
    }
}
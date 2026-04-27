import java.util.ArrayList;
import java.util.Scanner;

//interfaccia
interface Registrabile{
    //metodo astratto
    void registrazione();
}

// classe astratta persona
abstract class Persona{

    private int età;
    private String nome;

    //costruttore
    public Persona(String nome, int età){
        this.nome = nome;
        this.età = età;
    }

    // getter e setter
    public int getEtà(){
        return età;
    }

    public void setEtà(int età){
        if(età>0){
            this.età = età;
        }else{
            System.out.println("Età non valida");
        }
    }
       
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //metodo astratto
    abstract void descriviRuolo();

    // stampa
    public void stampa(){
        System.out.println(nome + " " + età);
    }

}

// docente
class Docente extends Persona implements Registrabile{

    private String materia;
    //lista di studenti
    private ArrayList<Studente> studentiMateria = new ArrayList<Studente>();

    //costruttore
    public Docente(String nome, int età, String materia){
        super(nome, età);
        this.materia = materia;
    }

    //getter e setter
    public String getMateria(){
        return materia;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }

    public ArrayList<Studente> getStudentiMateria(){
        return studentiMateria;
    }

    //implementazone descriviRuolo
    public void descriviRuolo(){
        System.out.println("Souno un docente di " + materia);
    }

    //implementazione registrazione
    public void registrazione(){
        System.out.println("Registrazione tramite segreteria didattica");
    }

    //aggiunta studente
    public void aggiungiStudente(Studente studente){
        studentiMateria.add(studente);
    }

    //rimozione studente da indice
    public void rimozioneStudente(int indice){
        studentiMateria.remove(indice);
    }

    // assegnare voto
    public void assegnareVoto(int indice, int voto){
        if(indice < studentiMateria.size()){
            studentiMateria.get(indice).setVoto(voto, materia);
        }else{
            System.out.println("Studente non trovato");
        }
    }

    // recuperare voti
    public ArrayList<Integer> recuperareVoti(String materia, int indice){
        if(indice < studentiMateria.size()){
            return studentiMateria.get(indice).getVoti(materia);
        }else{
            System.out.println("Studente non trovato");
            return null;
        }
    }

}

//studente
class Studente extends Persona{

    //liste multiple di voti in base alla materia
    private ArrayList<ArrayList<Integer>> votiMaterie = new ArrayList<ArrayList<Integer>>();
    //classi frequentate
    private ArrayList<String> classiFrequentate = new ArrayList<String>();

    //costruttore
    public Studente(String nome, int età){
        super(nome, età);
    }

    //implementazione metodo astratto
    public void descriviRuolo(){
        System.out.println("Sono uno studente delle classi di " + classiFrequentate);
    }

    //implementazione metodo astratto
    public void registrazione(){
        System.out.println("Registrazione tramite modulo online");
    }

    // registrare una materia
    public void registraMateria(String materia){
        if(!classiFrequentate.contains(materia.toLowerCase())){
            //inserimento materia
            classiFrequentate.add(materia.toLowerCase());
            votiMaterie.add(new ArrayList<Integer>());
        }else{
            System.out.println("La materia " + materia + " è già stata registrata");
        }
    }

    // assegnare voto
    public void setVoto(int voto, String materia){
        //controllo voto
        if(voto<0 || voto>10){
            System.out.println("Il voto non è valido");
            return;
        }
        //Controllo posizione della materia
        if(classiFrequentate.contains(materia.toLowerCase())){
            votiMaterie.get(classiFrequentate.indexOf(materia.toLowerCase())).add(voto);
        }else{
            System.out.println("La materia " + materia + " non è registrata");
        }
    }

    //recuperare voti
    public ArrayList<Integer> getVoti(String materia){
        if(classiFrequentate.contains(materia.toLowerCase())){
            //Controllo posizione della materia
            return votiMaterie.get(classiFrequentate.indexOf(materia.toLowerCase()));
        }else{
            System.out.println("La materia " + materia + " non è registrata");
            return null;
        }
    }
}

public class GestioneScuola{
    //Funzioni helper
    //stampa studenti
    public static void stampaStudenti(ArrayList<Studente> studenti){
        for(int i = 0; i < studenti.size(); i++){
            System.out.println(i + ". Nome: " + studenti.get(i).getNome()
                    + " Età: " + studenti.get(i).getEtà());
        }
    }

    // stampa docenti
    public static void stampaDocenti(ArrayList<Docente> docenti){
        for(int i = 0; i < docenti.size(); i++){
            System.out.println(i + ". Nome: " + docenti.get(i).getNome()
                    + " Età: " + docenti.get(i).getEtà()
                    + " Materia: " + docenti.get(i).getMateria());
        }
    }

    // Scelta studente
    public static Studente scegliStudente(ArrayList<Studente> studenti, Scanner sc){
        stampaStudenti(studenti);

        System.out.println("Inserisci nome studente:");
        String nome = sc.next();
        //ricerca
        for(Studente s : studenti){
            if(s.getNome().equalsIgnoreCase(nome)){
                return s;
            }
        }

        System.out.println("Studente non trovato");
        return null;
    }

    // Scelta docente
    public static Docente scegliDocente(ArrayList<Docente> docenti, Scanner sc){
        stampaDocenti(docenti);

        System.out.println("Inserisci nome docente:");
        String nome = sc.next();
        //ricerca
        for(Docente d : docenti){
            if(d.getNome().equalsIgnoreCase(nome)){
                return d;
            }
        }

        System.out.println("Docente non trovato");
        return null;
    }

    //controllo esistenza docente
    public static boolean docenteEsiste(ArrayList<Docente> docenti, String nome, String materia){

        for(Docente d : docenti){
            if(d.getNome().equalsIgnoreCase(nome) ||
            d.getMateria().equalsIgnoreCase(materia)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        //creazione scuola
        ArrayList<Studente> studenti = new ArrayList<Studente>();
        ArrayList<Docente> docenti = new ArrayList<Docente>();
        //creazione scanner
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Scanner floatScanner = new Scanner(System.in);
        //ciclo principale
        while (true) {
            //menu per creare docente, studente,registrare materia, assegnare voti o stampare voti
            System.out.println("1. Crea docente");
            System.out.println("2. Crea studente");
            System.out.println("3. Registra studente a materia");
            System.out.println("4. Assegnare voti");
            System.out.println("5. Stampa voti");
            System.out.println("6. Esci");

            int scelta = intScanner.nextInt();
            Studente studente;
            Docente docente;
            ArrayList<Studente> studentiDocente;
            switch (scelta){
                case 1:
                    //creazione docente
                    System.out.println("Inserisci nome docente");
                    String nomeDocente = stringScanner.next();
                    System.out.println("Inserisci età docente");
                    int etàDocente = intScanner.nextInt();
                    System.out.println("Inserisci materia docente");
                    String materiaDocente = stringScanner.next();
                    //controllo se gia presente docente di quella materia
                    if(docenteEsiste(docenti, nomeDocente, materiaDocente)){
                        System.out.println("Docente già presente (nome o materia duplicata)");
                        break;
                    }
                    docente = new Docente(nomeDocente, etàDocente, materiaDocente);
                    docenti.add(docente);
                    System.out.println("Docente creato con successo");
                    docente.registrazione();
                    break;
                case 2:
                    //creazione studente
                    System.out.println("Inserisci nome studente");
                    String nomeStudente = stringScanner.next();
                    System.out.println("Inserisci età studente");
                    int etàStudente = intScanner.nextInt();
                    //controllo se gia presente studente di quella materia
                    boolean trovatoStudente = false;
                    for(Studente s : studenti){
                        if(s.getNome().equalsIgnoreCase(nomeStudente)){
                            trovatoStudente = true;
                            break;
                        }
                    }
                    if(trovatoStudente){
                        System.out.println("Studente gia presente");
                        break;
                    }
                    //creazione studente
                    studente = new Studente(nomeStudente, etàStudente);
                    //aggiunta studente
                    studenti.add(studente);
                    System.out.println("Studente creato con successo");
                    studente.registrazione();
                    break;

                case 3:
                    //registrazione studente a materia
                    System.out.println("Lista studenti");
                    //scelta studente
                    studente = scegliStudente(studenti, stringScanner);
                    if(studente == null) break;

                    System.out.println("Inserisci materia");
                    String materia = stringScanner.next();
                    
                    studente.registraMateria(materia);
                    //aggiunta studente a docente di quella materia
                    for(Docente d : docenti){
                        if(d.getMateria().equalsIgnoreCase(materia)){
                            d.aggiungiStudente(studente);;
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Lista docenti");
                    //stampa lista docenti e scelta docente
                    docente = scegliDocente(docenti, stringScanner);
                    if(docente == null){
                        System.out.println("Docente non trovato");
                        break;
                    } 

                    studentiDocente = docente.getStudentiMateria();
                    //controllo studenti
                    if(studentiDocente == null || studentiDocente.isEmpty()){
                        System.out.println("Nessun studente registrato");
                        break;
                    }
                    System.out.println("Lista studenti");
                    //scelta studente
                    studente = scegliStudente(studentiDocente, stringScanner);
                    if(studente == null) break;
                    //assegnazione voto
                    System.out.println("Scegli il voto");
                    int voto = intScanner.nextInt();
                    docente.assegnareVoto(studentiDocente.indexOf(studente), voto);
                    System.out.println("Voto assegnato con successo");
                    break;
                case 5:
                    System.out.println("Lista docenti");
                    //stampa lista docenti e scelta docente
                    docente = scegliDocente(docenti, stringScanner);
                    if(docente == null){
                        System.out.println("Docente non trovato");
                        break;
                    } 
                    //stampa lista studenti
                    studentiDocente = docente.getStudentiMateria();
                    if(studentiDocente == null){
                        System.out.println("Nessun studente registrato");
                        break;
                    }
                    System.out.println("Lista studenti");
                    //scelta studente
                    studente = scegliStudente(studentiDocente, stringScanner);
                    if(studente == null) break;
                    ArrayList<Integer> voti = docente.recuperareVoti(docente.getMateria(), studentiDocente.indexOf(studente));
                    //stampa voti
                    System.out.println("Voti dello studente alla materia " + docente.getMateria());
                    for(int i = 0; i < voti.size(); i++){
                        System.out.println(i + ". " + voti.get(i));
                    }
                    break;
                case 6:
                    //Uscita dal programma
                    System.out.println("Esci dal programma");
                    return;
            }
        }
        
    }
}

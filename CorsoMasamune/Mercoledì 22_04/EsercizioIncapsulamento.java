import java.util.ArrayList;
import java.util.Scanner;
public class EsercizioIncapsulamento {
    public static void main(String[] args) {
        ArrayList<Studente> studenti_o = new ArrayList<Studente>();
        Studente s1 = new Studente("Tommy", 5);
        //stampa i valori
        s1.stampa();
        // prova a cambiare il voto fallendo
        s1.setVoto(11);
        s1.stampa();
        // prova a cambiare il voto
        s1.setVoto(7);
        s1.stampa();
        Studente s2 = new Studente("Maria", 7);
        Studente s3 = new Studente("Luca", 3);
        //aggiungi studenti alla lista
        studenti_o.add(s1);
        studenti_o.add(s2);
        studenti_o.add(s3);
        //ricerca studente con nome
        Scanner stringScanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Inserisci il nome del studente o premi 'esc' per uscire");
            String nome = stringScanner.nextLine();
            //controlla se è stato premuto 'esc'
            if(nome.equalsIgnoreCase("esc")) {
                System.out.println("Esci dal programma");
                break;
            }
            boolean trovato = false;
            for(Studente s : studenti_o) {
                //trova lo studente con quel nome
                if(s.getNome().equalsIgnoreCase(nome)) {
                    s.stampa();
                    trovato = true;
                    break;
                }
            }
            if(!trovato) {
                System.out.println("Studente non trovato");
            }
        }
    }
}

class Studente {
    private String nome;
    private int voto;
    private int id;
    static private int numeroStudenti=0;

    //costruttore
    Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        this.id = numeroStudenti;
        numeroStudenti++;
    }

    //getter
    public String getNome() {
        return nome;
    }
    public int getVoto() {
        return voto;
    }
    public int getId() {
        return id;
    }

    //setter
    public void setVoto(int voto) {
        //controlla che il voto sia compreso tra 0 e 10
        if (voto>=0 && voto<=10) {
            this.voto = voto;
        }else {
            System.out.println("Voto non valido");
        }
    }

    //metodi pubblici
    public void stampa() {
        System.out.println("Studente " + nome + " voto: " + voto);
    }
}

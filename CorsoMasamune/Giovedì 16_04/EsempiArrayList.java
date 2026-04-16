import java.util.ArrayList;
import java.util.Collections;

public class EsempiArrayList {
    public static void main(String[] args) {
        // ArrayList è una classe che implementa una lista dinamica, che può crescere o diminuire di dimensione a seconda delle esigenze.
        //Definiamo un ArrayList di interi
        ArrayList<Integer> numeri_O = new ArrayList<>();
        // Aggiungiamo alcuni numeri_O alla lista
        numeri_O.add(1);
        numeri_O.add(2);
        numeri_O.add(3);
        // Stampa la lista
        System.out.println(numeri_O);
        // Rimuoviamo il secondo elemento (indice 1)
        numeri_O.remove(1);
        // Stampa la lista dopo la rimozione
        System.out.println(numeri_O);
        // Aggiungiamo un nuovo numero alla fine della lista
        ArrayList<String> nomi_O = new ArrayList<>();
        nomi_O.add("Mario");
        nomi_O.add("Luigi");
        // Stampa la lista dei nomi_O
        System.out.println(nomi_O);
        // Accediamo al primo nome della lista
        System.out.println("Primo nome : " + nomi_O.get(0));
        // Stampa la dimensione della lista dei nomi_O
        System.out.println(nomi_O.size() + " nomi_O nella lista");
        ArrayList<Integer> numeriProva_O = new ArrayList<>();
        // Aggiungiamo numeri_O alla lista
        for (int i = 0; i < 10; i++) {
            numeriProva_O.add((int) (Math.random() * 100)); // Aggiunge un numero_O casuale tra 0 e 99
        }
        // Stampa la lista dei numeri_O di prova
        System.out.println(numeriProva_O);
        // Stampa lista ordinata
        Collections.sort(numeriProva_O);
        System.out.println("Lista ordinata: " + numeriProva_O);
        nomi_O.clear(); // Rimuove tutti gli elementi dalla lista dei nomi_O
        System.out.println("Lista dei nomi_O dopo clear: " + nomi_O);
        nomi_O.add("Peach");
        // Verifica se "Peach" è presente nella lista dei nomi_O
        System.out.println("La lista dei nomi_O contiene 'Peach': " + nomi_O.contains("Peach"));
    }
    
}
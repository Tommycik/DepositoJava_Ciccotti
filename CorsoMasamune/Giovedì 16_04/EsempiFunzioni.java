public class EsempiFunzioni {
    public static void main(String[] args) {
        // Una funzione è un blocco di codice che esegue un compito specifico e può essere richiamato da altre parti del programma.
        // Definiamo una funzione che prende due numeri_O interi come input e restituisce la loro somma
        int a = 5;
        int b = 10;
        int risultato = somma(a, b);
        System.out.println("La somma di " + a + " e " + b + " è: " + risultato);
        // Definiamo una funzione che stampa un messaggio personalizzato
        stampaMessaggio("Ciao, questa è una funzione che stampa un messaggio!");
    }
    // Definizione della funzione somma
    public static int somma(int x, int y) {
        return x + y;
    }
    static void stampaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
}
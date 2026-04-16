
public class EserciziFunzioni {
    public static void main(String[] args) {
        int fattoriale=3;
        System.out.println("Il fattoriale di " + fattoriale + " è: " + calcolaFattoriale(fattoriale));
        System.out.println("Il fattoriale di -5 è: " + calcolaFattoriale(-5));
        System.out.println("Il fattoriale di 0 è: " + calcolaFattoriale(0));
        calcoloFattoriale("test");
    }
    // Definizione della funzione calcolaFattoriale che accetta un numero intero come parametro e restituisce il suo fattoriale
    public static int calcolaFattoriale(int n) {
        //
        if (n < 0) {
            // Gestione del caso in cui il numero è negativo, poiché il fattoriale non è definito per numeri negativi
            System.out.println("Numero negativo non valido");
            return -1;
        }else if (n == 0 || n == 1) {
            // Il fattoriale di 0 e 1 è 1
            return 1;
        } else {
            // Calcolo ricorsivo del fattoriale: n! = n * (n-1)!
            return n * calcolaFattoriale(n - 1);
        }
    }
    public static void calcoloFattoriale(String input) {
        System.out.println("Inserisci un numero valido");
    }
    
}

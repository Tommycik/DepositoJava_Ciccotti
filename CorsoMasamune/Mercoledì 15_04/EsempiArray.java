public class EsempiArray {
    public static void main(String[] args) {
        // Dichiarazione e inizializzazione
        int[] numeri = new int[5];  
        // Array di dimensione 5
        int[] valori = {1, 2, 3, 4, 5}; 
        // Stampa primpo elemento dell'array valori
        System.out.println("Primo elemento di valori: " + valori[0]);
        for (int i : valori) {
            System.out.println(i);
            // Stampa ogni elemento dell'array valori usnado i come indice
            System.out.println(valori[i-1]);
        }
        System.out.println("Lunghezza dell'array valori: " + valori.length);
        System.out.println("Nome della classe dell'array: " + valori.getClass().getName());
        int [] copiaValori = valori.clone();
        System.out.println("Copia dell'array valori: ");
        for (int i : copiaValori) {
            System.out.println(i);
        }

    }
}

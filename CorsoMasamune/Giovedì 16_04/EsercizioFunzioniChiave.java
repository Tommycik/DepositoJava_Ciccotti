public class EsercizioFunzioniChiave {
    
    public static int somma(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
    // multiply con numeri interi
    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
    // multiply con numeri in virgola mobile
    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
    // Funzione per stampare un array di interi
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    // Funzione ricorsiva che somma i primi n numeri naturali
    public static int sommaNaturali(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sommaNaturali(n - 1);
        }
    }
   
    //
    public static void set(int oldValue, int newValue) {
        System.out.println("Valore originale di oldValue: " + oldValue);
        System.out.println("Valore originale di newValue: " + newValue);
        int temp = oldValue; // Salva il valore originale di oldValue
        oldValue = newValue;
        newValue = temp; // Modifica newValue per dimostrare che non influisce su oldValue
        System.out.println("Valore di oldValue dopo la modifica: " + oldValue);
        System.out.println("Valore di newValue dopo la modifica: " + newValue);
    }

    // Funzione per dimostrare che gli array vengono modificati all'interno della funzione
    public static void setArray(int[] array, int index, int newValue) {
        if (index >= 0 && index < array.length) {
            array[index] = newValue;
        }
    }

    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 10;
        System.out.println("La somma di " + firstNumber + " e " + secondNumber + " è: " + somma(firstNumber, secondNumber));
        System.out.println("La moltiplicazione di " + firstNumber + " e " + secondNumber + " è: " + multiply(firstNumber, secondNumber));
        double firstDouble = 2.5;
        double secondDouble = 4.0;
        System.out.println("La moltiplicazione di " + firstDouble + " e " + secondDouble + " è: " + multiply(firstDouble, secondDouble));
        int n = 7;
        System.out.println("La somma dei primi " + n + " numeri naturali è: " + sommaNaturali(n));
        int oldValue = 10;
        int newValue = 20;
        set(oldValue, newValue);
        System.out.println("Il valore della variabile dopo la chiamata a set è: " + oldValue);
        int[] array = {1, 2, 3, 4, 5};
        //stampa l'array prima della modifica
        printArray(array);
        setArray(array, 2, newValue);
        // Stampa l'array dopo la modifica per dimostrare che è stato modificato
        printArray(array);
    }
}

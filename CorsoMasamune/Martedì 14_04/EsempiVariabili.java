public class EsempiVariabili {
    public static void main(String[] args) {
        //Test println
        System.out.println("Hello World!");
        System.out.println("TUTTO OK!");
        // Test print
        System.out.println("sbagliato!");
        System.out.print("Hello World! ");
        System.out.print("I will print on the same line.");
        // Dichiarazione e inizializzazione di variabili
        // type variableName = value;
        int intTest = 10;
        double doubleTest = 3.14d;
        String testTextString = "Ciao, mondo!";
        boolean booleanTest = true;
        //Dichiarazione e inizializzazione separate
        boolean testBoolean;
        testBoolean = false;
        testBoolean = true;
        //Test println con variabili
        System.out.println(intTest);
        System.out.println(doubleTest);
        //Test println con espressioni e virgolette
        System.out.println("3*3");
        System.out.println(3*3);
        //Test print con variabili
        System.out.print(testTextString);
        System.out.print(booleanTest);
        //Esempio costante
        final int testFinal = 15;
        // Errore testFinal = 20; // Non è possibile modificare il valore di una costante
        //Test concatenazione
        String text = "mondo";
        System.out.println("Ciao " + text);
        // Variabile con concatenazione
        String secondText = "Ciao";
        String fullTexString = secondText + " " + text;
        System.out.println(fullTexString);  
        // Test concatenazione stringa e numero
        System.out.println(fullTexString + 3);
        // Definizione a cascata
        int x = 5;
        int y = 10;
        System.out.println(x + y);
        // Definizione a riga univoca
        int a=5, b=10, c=15;
        System.out.println(a + b + c);
        // Definizione e inizializzazione separate ma con stesso valore
        int d, e, f;
        d = e = f = 20;
        System.out.println(d + e + f);
        // Test double e float, vanno aggiunti la d e la f
        double doubleTest2 = 3.14d;
        float floatTest = 3.14f; 
        // Si possono scrivere in notazione scientifica
        float myFloat = 35e3f; // 35 * 10^3
        double myDouble = 12E4d; // 12 * 10^4
        // Tipo booleano può avere solo due valori 
        boolean isJavaFun = true;
        boolean isFerrari = false;
        // Se non inizializzato è falso, bestPractice è sempre inizializzare
        String m = "Tommaso";
        int n = 25;
        // La stringa ha molti metodi, ad esempio length() per la lunghezza della stringa
        System.out.println(m.length());
    }
}

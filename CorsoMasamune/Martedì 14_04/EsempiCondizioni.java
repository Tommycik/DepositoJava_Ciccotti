public class EsempiCondizioni {
    public static void main(String[] args) {
        // Esempio di condizione if
        int x = 10;
        int y = 5;
        int z = 15;
        System.out.println("x is " + x);
        System.out.println("y is " + y);
        System.out.println("z is " + z);

        // Maggioranza
        System.out.println("x > y: " + (x > y)); // true
        // Maggioranza o ugualianza
        System.out.println("x >= y: " + (x >= y)); // true
        // Minoranza
        System.out.println("x < z: " + (x < z)); // true    
        // Minoranza o ugualianza
        System.out.println("x <= z: " + (x <= z)); // true
        // Ugualianza
        System.out.println("x == y: " + (x >= y)); // true
        // Disugualianza
        System.out.println("x != z: " + (x != z)); // true
        //And logico
        System.out.println("x > y && x < z: " + (x > y && x < z)); // true
        //Or logico
        System.out.println("x > z || x < y: " + (x > z || x < y)); // false
        //Not logico
        System.out.println("!(x > y): " + !(x > y)); // false
        // Test condizione if
        if(x > y) {
            System.out.println("x is greater than y");
        }
        // Test condizione if-else
            int time = 20;
        if(time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Test condizione if-else else if
        time = 22;
        if(time < 10) {
            System.out.println("Good morning.");
        } else if(time < 20) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
    }
}

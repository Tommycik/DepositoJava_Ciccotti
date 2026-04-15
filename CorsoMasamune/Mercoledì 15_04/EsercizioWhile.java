public class EsercizioWhile {

    public static void main(String[] args) {
        // Dichiarazione variabili
       String password;
       String correctPassword = "java123";
       int tentativi = 0;
       boolean correctPasswordFound = false;
        // Scanner per input   
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // Ciclo per tentativi password
        while(tentativi < 3) {
            // Input password
            System.out.println("Inserisci la password:");
            password = scanner.nextLine();
            // Incremento tentativi
            tentativi++;
            if(password.equals(correctPassword)) {
                correctPasswordFound = true;
                break;
            }
        }

        String risposta;
        if(correctPasswordFound) {
            do{
                //input risposta
                System.out.println("Vuoi accedere al sistema? (s/n)");
                risposta = scanner.nextLine();       
            } while(!(risposta.equals("s") || risposta.equals("n")));
            switch (risposta) {
                case "s":
                    System.out.println("Accesso al sistema effettuato.");
                    break;
                case "n":
                    System.out.println("Accesso al sistema annullato.");
                default:
                    System.out.println("Risposta non valida.");
                    break;
            }
        }else {
            System.out.println("Accesso bloccato.");
        }
        
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class TestPrima17 {
    //Funzione input x addendi
    public static ArrayList<Double> inserimentoAddendi() {
        ArrayList<Double> addendi = new ArrayList<>();
        while(true) {
            System.out.println("Inserire l'addendo o uscire?(i/u)");
            String risposta = new Scanner(System.in).nextLine();
            if(risposta.equals("u")) {
                break;
            }else if(risposta.equals("i")) {
                System.out.println("Inserisci l'addendo:");
                addendi.add(new Scanner(System.in).nextDouble());
            }else {
                System.out.println("Risposta non valida. Riprova.");
            }
        }
        return addendi;
    }
    //Somma a x elementi
    public static double somma(ArrayList<Double> addendi) {
        double risultato = 0;
        for (double addendo : addendi) {
            risultato += addendo;
        }

        System.out.println("Risultato: " + risultato);
        return risultato;
    }
    //Sottrazione a x elementi
    public static double sottrazione(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        for (int i = 1; i < addendi.size(); i++) {
            risultato -= addendi.get(i);
        }

        System.out.println("Risultato: " + risultato);
        return risultato;
    }
    //Moltiplicazione a x elementi
    public static double moltiplicazione(ArrayList<Double> addendi) {
        double risultato = 1;
        for (double addendo : addendi) {
            risultato *= addendo;
        }

        System.out.println("Risultato: " + risultato);
        return risultato;
    }
    //Divisione a x elementi
    public static double divisione(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        for (int i = 1; i < addendi.size(); i++) {
            if(addendi.get(i) == 0) {
                System.out.println("Errore: divisione per zero.");
                return Double.NaN;
            }
            risultato /= addendi.get(i);
        }

        System.out.println("Risultato: " + risultato);
        return risultato;
    }
    //Esponenziale a x elementi
    public static double esponenziale(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        for (int i = 1; i < addendi.size(); i++) {
            risultato = Math.pow(risultato, addendi.get(i));
        }
        System.out.println("Risultato: " + risultato);
        return risultato;
    }
    
    public static void main(String[] args) {
        //ArrayList per utenti e password
        ArrayList<String> utenti_o = new ArrayList<>();
        ArrayList<String> passwords_o = new ArrayList<>();
        int maxOperazioni = 4;
        boolean stop = false;
        Scanner stringScanner = new Scanner(System.in);
        // Ciclo principale del programma
        while (!stop) {
            // ArrayList per addendi, risultati e operatori
            ArrayList<ArrayList<Double>> addendi = new ArrayList<>();
            ArrayList<Double> risultati = new ArrayList<>();
            ArrayList<String> operatori = new ArrayList<>();
            //Registrazione utente o login
            String risposta;
            // Ciclo per registrazione o login
            while(true) {
                do{
                    System.out.println("Sei un nuovo utente? (s/n)");
                    risposta = stringScanner.nextLine();
                    if(risposta.equals("s") || risposta.equals("n")) {
                        break;
                    }else {
                        System.out.println("Risposta non valida. Riprova.");
                    }
                } while (true); 
                // Registrazione utente
                if(risposta.equals("s")) {
                    System.out.println("Registrazione utente:");
                    System.out.println("Inserisci nome utente:");
                    String newUsername;
                    // Controllo se il nome utente è già esistente
                    newUsername = stringScanner.nextLine();
                    if(utenti_o.contains(newUsername)) {
                        System.out.println("Nome utente già esistente. Riprova.");
                        continue;
                    }else {
                        utenti_o.add(newUsername);
                    }
                    // Inserimento password
                    System.out.println("Inserisci password:");
                    String newPassword = stringScanner.nextLine();
                    utenti_o.add(newUsername);
                    passwords_o.add(newPassword);
                    System.out.println("Registrazione completata. Puoi ora effettuare il login.");
                    break;
                }else {
                    // Login utente
                    System.out.println("Login utente:");
                    System.out.println("Inserisci nome utente:");
                    String username = stringScanner.nextLine();
                    System.out.println("Inserisci password:");
                    String password = stringScanner.nextLine();
                    // Controllo se il nome utente esiste e se la password è corretta
                    if(utenti_o.contains(username)) {
                        int index = utenti_o.indexOf(username);
                        if(passwords_o.get(index).equals(password)) {
                            System.out.println("Login effettuato con successo. Benvenuto, " + username + "!");
                            break;
                        }else {
                            System.out.println("Password errata. Riprova.");
                            continue;
                        }
                    }else {
                        System.out.println("Nome utente non trovato. Riprova.");
                        continue;

                    }
                }
            }

            for(int i = 0; i < maxOperazioni && !stop; i++) {
                //Menu operazioni: Somma, Sottrazione, Moltiplicazione, Divisione, Esponenziale
                // Poi lista addendi, operazioni, risultati e uscita
                System.out.println("Scegli un'operazione:");
                System.out.println("1. Somma");
                System.out.println("2. Sottrazione");
                System.out.println("3. Moltiplicazione");
                System.out.println("4. Divisione");
                System.out.println("5. Esponenziale");
                System.out.println("6. Visualizza operazioni effettuate");
                System.out.println("7. Visualizza addendi");
                System.out.println("8. Visualizza risultati");
                System.out.println("9. Esci");
                // Controllo operazione scelta
                int operazione = new java.util.Scanner(System.in).nextInt();
                ArrayList<Double> addendiOperazione;
                //Verifica operazione scelta
                switch (operazione) {
                    case 1:
                        addendiOperazione = inserimentoAddendi();
                        addendi.add(addendiOperazione);
                        risultati.add(somma(addendiOperazione));
                        operatori.add("+");
                        break;
                    case 2:
                        addendiOperazione = inserimentoAddendi();
                        addendi.add(addendiOperazione);
                        risultati.add(sottrazione(addendiOperazione) );
                        operatori.add("-");
                        break;
                    case 3:
                        addendiOperazione = inserimentoAddendi();
                        addendi.add(addendiOperazione);
                        risultati.add(moltiplicazione(addendiOperazione) );
                        operatori.add("*");
                        break;
                    case 4:
                        addendiOperazione = inserimentoAddendi();
                        addendi.add(addendiOperazione);
                        risultati.add(divisione(addendiOperazione));
                        operatori.add("/");
                        break;
                    case 5:
                        addendiOperazione = inserimentoAddendi();
                        addendi.add(addendiOperazione);
                        risultati.add(esponenziale(addendiOperazione));
                        operatori.add("^");
                        break;
                    case 6:
                        // Stampa operazioni effettuate
                        System.out.println("Operazioni effettuate:");
                        for(int j = 0; j < operatori.size(); j++) {
                            // Stampa operazione
                            for(int k = 0; k < addendi.get(j).size()-1; k++) {
                                System.out.print(addendi.get(j).get(k) + " " + operatori.get(j) + " ");
                            }
                            // Stampa risultato
                            System.out.print(addendi.get(j).get(addendi.get(j).size()-1));
                            System.out.println(" = " + risultati.get(j));
                        }
                        break;
                    case 7:
                        // Stampa addendi
                        System.out.println("Addendi:");
                        for(ArrayList<Double> gruppoAddendi : addendi) {
                            System.out.println(gruppoAddendi);
                        }
                        break;
                    case 8:
                        // Stampa risultati
                        System.out.println("Risultati:");
                        for(Double risultato : risultati) {
                            System.out.println(risultato);
                        }
                        break;
                    case 9: 
                        // Uscita dal programma
                        System.out.println("Uscita dal programma. Arrivederci!");
                        stop = true;
                        break;
                    default:
                        // Operazione non valida
                        System.out.println("Operazione non valida. Riprova.");
                        i--;
                        break;
                }    
                
            }
            //Avverte l'utente che deve fare di nuovo il login
            System.out.println("Numero di operazioni massime per sessione raggiunto, per effettuare nuove operazioni effettua il login");    
        }
    }
}
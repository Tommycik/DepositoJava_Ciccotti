import java.util.ArrayList;
import java.util.Scanner;

public class TestPrima17 {

    //Funzione input x addendi
    public static ArrayList<Double> inserimentoAddendi() {
        //ArrayList per addendi inseriti dall'utente
        ArrayList<Double> addendi = new ArrayList<>();
        while(true) {
            System.out.println("Inserire l'addendo o uscire?(i/u)");
            String risposta = new Scanner(System.in).nextLine();
            if(risposta.equals("u")) {
                System.out.println("Inserimento terminato.");
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
        //Calcolo della somma
        for (double addendo : addendi) {
            risultato += addendo;
        }
        //Stampa e ritorno del risultato
        System.out.println("Risultato: " + risultato);
        return risultato;
    }

    //Sottrazione a x elementi
    public static double sottrazione(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        //Calcolo della sottrazione
        for (int i = 1; i < addendi.size(); i++) {
            risultato -= addendi.get(i);
        }
        //Stampa e ritorno del risultato
        System.out.println("Risultato: " + risultato);
        return risultato;
    }

    //Moltiplicazione a x elementi
    public static double moltiplicazione(ArrayList<Double> addendi) {
        double risultato = 1;
        //Calcolo della moltiplicazione
        for (double addendo : addendi) {
            risultato *= addendo;
        }
        //Stampa e ritorno del risultato
        System.out.println("Risultato: " + risultato);
        return risultato;
    }

    //Divisione a x elementi
    public static double divisione(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        //Calcolo della divisione
        for (int i = 1; i < addendi.size(); i++) {
            //Controllo divisione per zero
            if(addendi.get(i) == 0) {
                System.out.println("Errore: divisione per zero.");
                return Double.NaN;
            }
            risultato /= addendi.get(i);
        }
        //Stampa e ritorno del risultato
        System.out.println("Risultato: " + risultato);
        return risultato;
    }

    //Esponenziale a x elementi
    public static double esponenziale(ArrayList<Double> addendi) {
        double risultato = addendi.get(0);
        //Calcolo dell'esponenziale
        for (int i = 1; i < addendi.size(); i++) {
            risultato = Math.pow(risultato, addendi.get(i));
        }
        //Stampa e ritorno del risultato
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
            ArrayList<ArrayList<Double>> addendi_o = new ArrayList<>();
            ArrayList<Double> risultati_o = new ArrayList<>();
            ArrayList<String> operatori_o = new ArrayList<>();
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
                ArrayList<Double> addendiOperazione_o;
                //Verifica operazione scelta
                switch (operazione) {
                    case 1:
                        //Inserimento addendi
                        addendiOperazione_o = inserimentoAddendi();
                        //Aggiunti addendi all'ArrayList
                        addendi_o.add(addendiOperazione_o);
                        //Aggiunto risultato all'ArrayList
                        risultati_o.add(somma(addendiOperazione_o));
                        //Aggiunta operazione all'ArrayList
                        operatori_o.add("+");
                        break;
                    case 2:
                        addendiOperazione_o = inserimentoAddendi();
                        addendi_o.add(addendiOperazione_o);
                        risultati_o.add(sottrazione(addendiOperazione_o) );
                        operatori_o.add("-");
                        break;
                    case 3:
                        addendiOperazione_o = inserimentoAddendi();
                        addendi_o.add(addendiOperazione_o);
                        risultati_o.add(moltiplicazione(addendiOperazione_o) );
                        operatori_o.add("*");
                        break;
                    case 4:
                        addendiOperazione_o = inserimentoAddendi();
                        addendi_o.add(addendiOperazione_o);
                        risultati_o.add(divisione(addendiOperazione_o));
                        operatori_o.add("/");
                        break;
                    case 5:
                        addendiOperazione_o = inserimentoAddendi();
                        addendi_o.add(addendiOperazione_o);
                        risultati_o.add(esponenziale(addendiOperazione_o));
                        operatori_o.add("^");
                        break;
                    case 6:
                        // Stampa operazioni effettuate
                        System.out.println("Operazioni effettuate:");
                        for(int j = 0; j < operatori_o.size(); j++) {
                            // Stampa operazione
                            for(int k = 0; k < addendi_o.get(j).size()-1; k++) {
                                System.out.print(addendi_o.get(j).get(k) + " " + operatori_o.get(j) + " ");
                            }
                            // Stampa risultato
                            System.out.print(addendi_o.get(j).get(addendi_o.get(j).size()-1));
                            System.out.println(" = " + risultati_o.get(j));
                        }
                        break;
                    case 7:
                        // Stampa addendi
                        System.out.println("Addendi:");
                        for(ArrayList<Double> gruppoAddendi : addendi_o) {
                            System.out.println(gruppoAddendi);
                        }
                        break;
                    case 8:
                        // Stampa risultati
                        System.out.println("Risultati:");
                        for(Double risultato : risultati_o) {
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
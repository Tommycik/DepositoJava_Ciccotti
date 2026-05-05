package EsercizioFabbricaMVC;

import java.util.Scanner;

import EsercizioFabbricaMVC.Model.*;
import EsercizioFabbricaMVC.Controller.*;
import EsercizioFabbricaMVC.View.*;

public class EsercizioFabbricaMVC {
    public static void main(String[] args) {
        //Istanza della fabbrica
        Fabbrica fabbrica = Fabbrica.getInstance();
        //Istanza della view della fabbrica
        FabbricaView view = new FabbricaView();
        //Istanza del controller della fabbrica
        FabbricaController fabbricaController = new FabbricaController(fabbrica, view);
        //Istanza dell'utente
        Utente utente = new Utente("Mario Rossi");
        //Istanza della view utente
        UtenteView utenteView = new UtenteView();
        //Istanza del controller utente
        UtenteController utenteController = UtenteController.getInstance(utente, utenteView);
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int scelta;
        do{
            //mostra menu
            utenteController.mostraMenu();
            //leggi scelta
            scelta = intScanner.nextInt();
            switch (scelta) {
                case 1:
                    //crea veicolo
                    if(utenteController.getUtente()==null){
                        System.out.println("Devi effettuare il login prima di creare un veicolo");
                        break;
                    }
                    fabbricaController.mostraMenuVeicoli();
                    int tipo = intScanner.nextInt();
                    intScanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = stringScanner.nextLine();

                    System.out.print("Targa: ");
                    String targa = stringScanner.nextLine();

                    fabbricaController.mostraMenuDecorator();
                    int decorator = intScanner.nextInt();
                    fabbricaController.creaVeicoloCompleto(tipo, nome, targa, decorator);
                    break;
                case 2:
                    //mostra storico
                    if(utenteController.getUtente()==null){
                        System.out.println("Devi effettuare il login prima di mostrare lo storico");
                        break;
                    }
                    fabbricaController.mostraVeicoliProdotti();
                    break;
                case 3:
                    //login
                    if(utenteController.getUtente()!=null){
                        System.out.println("Devi effettuare il logout prima di effettuare il login");
                        break;
                    }
                     System.out.print("Inserisci nome utente: ");
                    String nomeUtente = stringScanner.nextLine();

                    Utente u = new Utente(nomeUtente);
                    utenteController.login(u);
                    break;
                case 4:
                    //logout
                    if(utenteController.getUtente()==null){
                        System.out.println("Non hai effettuato il login");
                        break;
                    }
                    utenteController.logout();
                    break;
                case 5:
                    //esci
                    System.out.println("Uscita dal programma");
                    return;
                default:
                    //scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }

        }while(true);
    }
}
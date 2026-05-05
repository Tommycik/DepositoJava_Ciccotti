package EsercizioFabbricaMVC.Controller;

import EsercizioFabbricaMVC.Model.Component;
import EsercizioFabbricaMVC.Model.Fabbrica;
import EsercizioFabbricaMVC.View.FabbricaView;
import EsercizioFabbricaMVC.Model.Auto;
import EsercizioFabbricaMVC.Model.Moto;
import EsercizioFabbricaMVC.Model.DecoratorNavigatore;
import EsercizioFabbricaMVC.Model.DecoratorMultimediale;
import EsercizioFabbricaMVC.Model.DecoratorSicurezza;
import java.util.ArrayList;
//classe FabbricaController
public class FabbricaController {
    
    private Fabbrica fabbrica;
    private FabbricaView view;
    //costruttore
    public FabbricaController(Fabbrica fabbrica, FabbricaView view) {
        this.fabbrica = fabbrica;
        this.view = view;
        this.fabbrica.aggiungiObserver(view);
    }
    //metodo per la creazione dei veicoli
    public void creaVeicoloCompleto(int tipoVeicolo, String nome, String targa, int tipoDecorazione) {
        Component veicolo = null;
        // Controllo tipo veicolo
        switch (tipoVeicolo) {

            case 1 :
                veicolo = new Auto(nome, targa);
                break;
            case 2 : 
                veicolo = new Moto(nome, targa);
                break;
            default :
                veicolo = null;
                break;
        };

        // Controllo se veicolo è nullo
        if (veicolo == null) {
            view.mostraMessaggio("Tipo veicolo non valido.");
            return;
        }

        // controllo decorazione
        switch (tipoDecorazione) {
            case 1 : 
                //crea veicolo con navigatore satellitare
                veicolo = new DecoratorNavigatore(veicolo);
                break;
            case 2 : 
                //crea veicolo con sistema multimediale
                veicolo = new DecoratorMultimediale(veicolo);
                break;
            case 3 :
                //crea veicolo con airbag di sicurezza
                veicolo = new DecoratorSicurezza(veicolo);
                break;
            case 4 :
                //crea veicolo con tutto
                veicolo = new DecoratorSicurezza(new DecoratorMultimediale(new DecoratorNavigatore(veicolo)));
                break;
            case 5 :
                //nessun decoratore
                break;
            default :
                //scelta non valida
                System.out.println("Scelta decoratore non valida");
                break;
        };

        // 3. Aggiunta alla fabbrica
        fabbrica.creaVeicolo(veicolo);
    }
    //metodo per la stamps dei veicoli prodotti
    public void mostraVeicoliProdotti() {
        ArrayList<Component> veicoli = fabbrica.getVeicoli();
        view.mostraVeicoliProdotti(veicoli);
    }
    //metodo per messaggio
    public void mostraMessaggio(String msg) {
        view.mostraMessaggio(msg);
    }
    //metodo per la stampa del menu veicoli
    public void mostraMenuVeicoli() {
        view.mostraMenuVeicoli();
    }
    //metodo per la stampa del menu decorator
    public void mostraMenuDecorator() {
        view.mostraMenuDecorator();
    }

}


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
    //metodo per la creazione di un veicolo
    public void creaAuto(String nome, String targa) {
        Component c = new Auto(nome, targa);
        fabbrica.creaVeicolo(c);
    }
    //metodo per la decorazione con navigatore satellitare
    public void creaVeicoloNavigatore(Component c) {
        Component d = new DecoratorNavigatore(c);
        fabbrica.creaVeicolo(d);
    }
    //metodo per la decorazione con sistema multimediale
    public void creaVeicoloMultimediale(Component c) {
        Component d = new DecoratorMultimediale(c);
        fabbrica.creaVeicolo(d);
    }
    //metodo per la decorazione con airbag di sicurezza
    public void creaVeicoloSicurezza(Component c) {
        Component d = new DecoratorSicurezza(c);
        fabbrica.creaVeicolo(d);
    }
    //metodo per la creazione di una moto
    public void creaMoto(String nome, String targa) {
        Component c = new Moto(nome, targa);
        fabbrica.creaVeicolo(c);
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
    //crea con tutto
    public void creaVeicoloTuttoDecorato(Component c) {
        fabbrica.creaVeicolo(new DecoratorSicurezza(new DecoratorMultimediale(new DecoratorNavigatore(c))));
    }
    //aggiungi un veicolo
    public void aggiungiVeicolo(Component c) {
        fabbrica.creaVeicolo(c);
    }
}


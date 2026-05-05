package EsercizioFabbricaMVC.View;

import java.util.ArrayList;

import EsercizioFabbricaMVC.Model.Component;
import EsercizioFabbricaMVC.Model.Observer;
//classe FabbricaView
public class FabbricaView implements Observer {
    //metodo per la stampa dei veicoli prodotti
    public void mostraVeicoliProdotti(ArrayList<Component> veicoli) {
        System.out.println("\n VEICOLI PRODOTTI: ");
        for (Component c : veicoli) {
            System.out.println(c.getDescrizione());
        }
    }
    //metodo per la stampa di un messaggio
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }
    //metodo per notificare di un nuovo veicolo prodotto
    @Override
    public void aggiorna(Component c) {
        System.out.println("\nNOTIFICA: Nuovo veicolo prodotto!");
        System.out.println(c.getDescrizione());
    }
    //mostra menu auto o moto
    public void mostraMenuVeicoli() {
        System.out.println("\nMENU VEICOLI: ");
        System.out.println("1. Crea un auto");
        System.out.println("2. Crea una moto");
    }
    //mostra menu decorator
    public void mostraMenuDecorator() {
        System.out.println("\nMENU DECORATOR: ");
        System.out.println("1. Crea un veicolo con navigatore satellitare");
        System.out.println("2. Crea un veicolo con sistema multimediale");
        System.out.println("3. Crea un veicolo con airbag di sicurezza");
        System.out.println("4. Tutto");
        System.out.println("5. Nessuno");
    }
}
package EsercizioFabbricaMVC.View;

import java.util.ArrayList;

import EsercizioFabbricaMVC.Model.Component;
import EsercizioFabbricaMVC.Model.Observer;
public class FabbricaView implements Observer {

    public void mostraMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Crea Veicolo");
        System.out.println("4. Mostra storico");
        System.out.println("0. Esci");
    }

    public void mostraVeicoliProdotti(ArrayList<Component> veicoli) {
        System.out.println("\n=== VEICOLI PRODOTTI ===");
        for (Component v : veicoli) {
            System.out.println(v.getDescrizione());
        }
    }

    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public void aggiorna(Component c) {
        System.out.println("\n[NOTIFICA] Nuovo veicolo prodotto!");
        c.getDescrizione();
    }
}
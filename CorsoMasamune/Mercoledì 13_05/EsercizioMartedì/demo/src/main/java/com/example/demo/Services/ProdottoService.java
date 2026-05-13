package com.example.demo.Services;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

//servizio per gestire i prodotti
@Service
public class ProdottoService {
    // lista dei nomi dei prodotti
    private List<String> nomiProdotti;
    //servizio per calcolare il prezzo scontato
    private final PrezzoService prezzoService;
    //mappa dei prezzi dei prodotti
    private Map<String, Double> prezziProdotti;
    //costruttore con iniezione
    public ProdottoService(PrezzoService prezzoService) {
        this.prezzoService = prezzoService;
        nomiProdotti = new ArrayList<>();
        prezziProdotti = new HashMap<>();
    }
    //metodo per inizializzare mappa dei prezzi
    @PostConstruct
    public void init() {
        nomiProdotti.add("Pantaloncini");
        nomiProdotti.add("Scarpe");
        nomiProdotti.add("Cinture");
        nomiProdotti.add("Calzini");
        nomiProdotti.add("Pantaloncini");
        nomiProdotti.add("Scarpe");
        nomiProdotti.add("Cinture");
        nomiProdotti.add("Calzini");
        for (String nomeProdotto : nomiProdotti) {
            prezziProdotti.put(nomeProdotto, nomiProdotti.size() * 10 + Math.random() * 10);
        }
    }
    // metodo per stampare il catalogo dei prodotti
    public void stampaCatalogo(int percentualeSconto) {
        System.out.println("========================================");
        System.out.println("  CATALOGO PRODOTTI — Sconto: " + percentualeSconto + "%");
        System.out.println("========================================");
        System.out.printf("%-25s %-12s %-12s%n",
            "Nome",
            "Prezzo",
            "Prezzo finale");
        for (String nomeProdotto : nomiProdotti) {
            double prezzo = prezziProdotti.get(nomeProdotto);
            double prezzoFinale = prezzoService.calcolaPrezzoScontato(prezzo, percentualeSconto);
            System.out.printf(
                "%-25s %-12.2f %-12.2f%n",
                nomeProdotto,
                prezzo,
                prezzoFinale
        );
        }
        System.out.println("========================================");
    }

}

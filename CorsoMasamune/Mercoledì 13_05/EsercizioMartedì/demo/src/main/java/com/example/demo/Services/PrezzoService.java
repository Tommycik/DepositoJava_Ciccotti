package com.example.demo.Services;
import org.springframework.stereotype.Service;
//servizio per calcolare prezzo scontato
@Service
public class PrezzoService {
    //calcola prezzo scontato
    public double calcolaPrezzoScontato(double prezzoOriginale, int percentualeSconto) {
        //java altriemnti tronca divisone tra interi
        double sconto = percentualeSconto / 100.0;
        return prezzoOriginale * (1-sconto);
    }
    
}

package com.example.demo.RestController;

import com.example.demo.Run.RunRecord;
import com.example.demo.Run.Location;
import com.example.demo.Run.Run;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// controller rest per gestire le corse
@RestController
@RequestMapping("/api/runs")
public class RunController {

    // lista per simulare un database
    private final List<RunRecord> runs = new ArrayList<>();

    // costruttore e inizializzazione dei dati
    public RunController() {
        runs.add(new RunRecord(0, "Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 100, Location.OUTDOOR));
        runs.add(new RunRecord(1, "Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 400, Location.INDOOR));
        runs.add(new RunRecord(2, "Run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 300, Location.OUTDOOR));
        runs.add(new RunRecord(3, "Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 200, Location.INDOOR));
        runs.add(new RunRecord(4, "Run", LocalDateTime.now(), LocalDateTime.now().plus(4, ChronoUnit.HOURS), 2100, Location.OUTDOOR));
    }


    //get generico
    @GetMapping
    public ResponseEntity<List<RunRecord>> findAll() {
        return ResponseEntity.ok(runs);
        
    }

    // get singola corsa
    @GetMapping("/{id}")
    public ResponseEntity<RunRecord> findById(@PathVariable Integer id) {
        //controllo lista
        if(runs.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        //ricerca per id
        for (RunRecord run : runs) {
            if (run.id() == id) {
                return ResponseEntity.ok(run);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // crea singola corsa
    @PostMapping
    public ResponseEntity<RunRecord> create(@RequestBody RunRecord newRun) {
        //controllo id univoco
        for (RunRecord run: runs){
            if(newRun.id() == run.id()){
                return ResponseEntity.badRequest().build();
            }
        }
        //aggiunta
        runs.add(newRun);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRun);
        
    }

    //  aggiorna una corsa
    @PutMapping("/{id}")
    public ResponseEntity<RunRecord> update(@PathVariable Integer id, @RequestBody RunRecord updatedRun) {
        //controllo id e lista
        if(runs.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        //ricerca per id
        for (RunRecord run : runs) {
            if (run.id() == id) {
                int index = runs.indexOf(run);
                //controllo id univoco
                for (RunRecord run2: runs){
                    if(updatedRun.id() == run2.id() && run.id() != run2.id()){
                        return ResponseEntity.badRequest().build();
                    }
                }
                //aggiornamento
                runs.set(index, updatedRun);
                return ResponseEntity.ok(updatedRun);
                
            }
        }
        return ResponseEntity.notFound().build();
    }

    // elimina singola corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        //controllo id e lista
        if (runs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        //ricerca per id
        for (RunRecord run : runs) {
            if (run.id() == id) {
                int index = runs.indexOf(run);
                //rimozione
                runs.remove(index);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}
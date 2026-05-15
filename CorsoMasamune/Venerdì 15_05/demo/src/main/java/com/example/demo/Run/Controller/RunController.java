package com.example.demo.Run.Controller;
import com.example.demo.Run.Location;
import com.example.demo.Run.Run;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.Run.Run;
import com.example.demo.Run.Location;
import com.example.demo.Run.Controller.Service.RunService;

import jakarta.validation.Valid;

// controller rest per gestire le corse
@RestController
//ora url dovrebbe essere stesso nome della tabella
@RequestMapping("/api/runs")
public class RunController {

    // niente più lista per simulare database ma usiamo runRepository
    private final RunService runService;

    // costruttore e injection di runRepository
    public RunController(RunService runService) {
        this.runService = runService;
    }


    //get generico
    @GetMapping
    public List<Run> findAll() {    
        return runService.findAll();
        
    }

    // get singola corsa
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        //ricerca per id
        Optional <Run> run = runService.findById(id);
        return run.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //get miles maggiori di un numero
    @GetMapping("/miles/{miles}")
    public List<Run> findByMilesGreaterThan(@PathVariable Integer miles) {
        return runService.findByMilesGreaterThan(miles);
    }

    // crea singola corsa e controlla errori validazione
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Run newRun, BindingResult bindingResult) {
        //controllo errori validazione
        if(bindingResult.hasErrors()){
            //creazione di un map per mantenere gli errori
            Map<String,String> errors = new HashMap<>();
            //iterazione su tutti gli errori
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            //ritorno errore
            return ResponseEntity.badRequest().body(errors);
        }
        Run savedRun = runService.save(newRun);
        return ResponseEntity.status(201).body(savedRun);
        
    }

    //  aggiorna una corsa, con binding result possaimo catturare gli errori di validazione
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Run updatedRun, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Run updated = runService.update(id, updatedRun);
        return ResponseEntity.ok(updated);
        
    }

    // elimina singola corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (runService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        runService.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }

}
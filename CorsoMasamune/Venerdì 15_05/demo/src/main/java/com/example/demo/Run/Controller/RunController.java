package com.example.demo.Run.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.Run.Controller.Service.RunService;
import com.example.demo.Run.Model.Location;
import com.example.demo.Run.Model.RunRequest;
import com.example.demo.Run.Model.RunResponse;

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
    public List<RunResponse> findAll() {
        return runService.findAll();
        
    }

    // get singola corsa
    @GetMapping("/{id}")
    public ResponseEntity<RunResponse> findById(@PathVariable Integer id) {
        //ricerca per id
        RunResponse run = runService.findById(id);
        return ResponseEntity.ok(run);
    }
    //get miles maggiori di un numero
    @GetMapping("/miles/{miles}")
    public List<RunResponse> findByMilesGreaterThan(@PathVariable Integer miles) {
        return runService.findByMilesGreaterThan(miles);
    }

    // crea singola corsa e controlla errori validazione
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RunRequest newRun) {
        //controllo errori validazione adesso è centralizzato
        RunResponse savedRun = runService.save(newRun);
        return ResponseEntity.status(201).body(savedRun);
        
    }

    //  aggiorna una corsa, con binding result possaimo catturare gli errori di validazione
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody RunRequest updatedRun) {
        //controllo errori validazione adesso è centralizzato
        RunResponse updated = runService.update(id, updatedRun);
        return ResponseEntity.ok(updated);
        
    }

    // elimina singola corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        runService.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }

}
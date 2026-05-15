package com.example.demo.Run.Controller;
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

    // crea singola corsa
    @PostMapping
    public ResponseEntity<Run> create(@Valid @RequestBody Run newRun) {
        Run savedRun = runService.save(newRun);
        return ResponseEntity.status(201).body(savedRun);
        
    }

    //  aggiorna una corsa
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @Valid @RequestBody Run updatedRun) {
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
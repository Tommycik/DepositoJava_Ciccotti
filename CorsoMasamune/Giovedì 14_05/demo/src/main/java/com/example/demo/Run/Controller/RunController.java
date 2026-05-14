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
import com.example.demo.Repository.RunRepository;

// controller rest per gestire le corse
@RestController
//ora url dovrebbe essere stesso nome della tabella
@RequestMapping("/api/runs")
public class RunController {

    // niente più lista per simulare database ma usiamo runRepository
    private final RunRepository runRepository;

    // costruttore e injection di runRepository
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    //get generico
    @GetMapping
    public List<Run> findAll() {    
        return runRepository.findAll();
        
    }

    // get singola corsa
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        //ricerca per id
        Optional <Run> run = runRepository.findById(id);
        return run.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // crea singola corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
        Run savedRun = runRepository.save(newRun);
        return ResponseEntity.status(201).body(savedRun);
        
    }

    //  aggiorna una corsa
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {
        Optional<Run> existing = runRepository.findById(id);
        // se non trova la corsa, restituisce errore
         if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Run run = existing.get();
        run.setTitle(updatedRun.getTitle());
        run.setStartedOn(updatedRun.getStartedOn());
        run.setCompletedOn(updatedRun.getCompletedOn());
        run.setMiles(updatedRun.getMiles());
        run.setLocation(updatedRun.getLocation());
        Run updated = runRepository.save(run);
        return ResponseEntity.ok(updated);}

    // elimina singola corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!runRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        runRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }

}
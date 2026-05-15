package com.example.demo.Run.Controller.Service;
import com.example.demo.Run.Run;
import com.example.demo.Run.Location;
import com.example.demo.Repository.RunRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
//service per run
@Service
public class RunService {
    private final RunRepository runRepository;

    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    //find by id optional
    public Optional<Run> findById(Integer id) {
        return runRepository.findById(id);
    }

    //find all
    public List<Run> findAll() {
        return runRepository.findAll();
    }

    //save
    public Run save(Run newRun) {
        return runRepository.save(newRun);
    }

    //update
    public Run update(Integer id, Run updatedRun) {
        Optional<Run> existing = runRepository.findById(id);
        // se non trova la corsa, restituisce errore
         if (existing.isEmpty()) {
            return null;
        }
        Run run = existing.get();
        run.setTitle(updatedRun.getTitle());
        run.setStartedOn(updatedRun.getStartedOn());
        run.setCompletedOn(updatedRun.getCompletedOn());
        run.setMiles(updatedRun.getMiles());
        run.setLocation(updatedRun.getLocation());
        Run updated = runRepository.save(run);
        return updated;
    }

    //delete
    public void deleteById(Integer id) {
        runRepository.deleteById(id);
    }

    //find by location
    public List<Run> findByLocation(Location location) {
        return runRepository.findByLocation(location);
    }
    //find by Title
    public List<Run> findByTitle(String title) {
        return runRepository.findByTitle(title);
    }
    //find by Miles maggiori di un numero
    public List<Run> findByMilesGreaterThan(Integer miles) {
        return runRepository.findByMilesGreaterThan(miles);
    }
}

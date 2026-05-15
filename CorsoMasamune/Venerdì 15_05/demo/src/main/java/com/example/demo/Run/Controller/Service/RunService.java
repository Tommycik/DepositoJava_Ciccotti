package com.example.demo.Run.Controller.Service;

import com.example.demo.Run.Repository.RunRepository;
import com.example.demo.ErrorResponse.RunNotFoundException;
import com.example.demo.Run.Model.Location;
import com.example.demo.Run.Model.Run;
import com.example.demo.Run.Model.RunRequest;
import com.example.demo.Run.Model.RunResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
//service per run
@Service
public class RunService {
    //repository
    private final RunRepository runRepository;
    //costruttore con iniezione di repository
    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    //metodo da run a run response
    private RunResponse toResponse(Run run) {
        return new RunResponse(run.getId(), run.getTitle(), run.getStartedOn(), run.getCompletedOn(), run.getMiles(), run.getLocation().name());
    }
    //metodo da run request a run
    private Run toRun(RunRequest runRequest) {
        return new Run(runRequest.title(), runRequest.startedOn(), runRequest.completedOn(), runRequest.miles(), runRequest.location());
    }
    //find by id optional
    public RunResponse findById(Integer id) {
        Run run = runRepository.findById(id).orElseThrow(() -> new RunNotFoundException(id));
        return toResponse(run);
    }

    //find all
    public List<RunResponse> findAll() {
        return runRepository.findAll().stream().map(this::toResponse).toList();
    }

    //save
    public RunResponse save(RunRequest newRun) {
        Run savingRun = toRun(newRun);
        Run savedRun = runRepository.save(savingRun);
        return toResponse(savedRun);
    }

    //update
    public RunResponse update(Integer id, RunRequest updatedRun) {
        Optional<Run> existing = runRepository.findById(id);
        // se non trova la corsa, restituisce errore
        if (existing.isEmpty()) {
            throw new RunNotFoundException(id);
        }
        Run run = existing.get();
        run.setTitle(updatedRun.title());
        run.setStartedOn(updatedRun.startedOn());
        run.setCompletedOn(updatedRun.completedOn());
        run.setMiles(updatedRun.miles());
        run.setLocation(updatedRun.location());
        Run updated = runRepository.save(run);
        return toResponse(updated);
    }

    //delete
    public void deleteById(Integer id) {
        if(!runRepository.existsById(id)){
            throw new RunNotFoundException(id);
        }
        runRepository.deleteById(id);
    }

    //find by location
    public List<RunResponse> findByLocation(Location location) {
        return runRepository.findByLocation(location).stream().map(this::toResponse).toList();
    }
    //find by Title
    public List<RunResponse> findByTitle(String title) {
        return runRepository.findByTitle(title).stream().map(this::toResponse).toList();
    }
    //find by Miles maggiori di un numero
    public List<RunResponse> findByMilesGreaterThan(Integer miles) {
        return runRepository.findByMilesGreaterThan(miles).stream().map(this::toResponse).toList();
    }
}

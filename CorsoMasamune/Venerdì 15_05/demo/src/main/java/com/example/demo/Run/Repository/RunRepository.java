package com.example.demo.Run.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Run.Run;
import com.example.demo.Run.Location;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

//interfaccia repository per Run, specifica per quale tabella è la repostory
//integer è per l'id
public interface RunRepository extends  JpaRepository<Run, Integer>{
    //trova per titolo, location, miles, orario di partenza e  orario di arrivo
    List<Run> findByTitle(String title);
    List<Run> findByLocation(Location location);
    List<Run> findByMilesGreaterThan(Integer miles);
    List<Run> findByStartedOnGreaterThan(LocalDateTime startedOn);
    List<Run> findByCompletedOnGreaterThan(LocalDateTime completedOn);
    //trova per nome e miles
    List<Run> findByTitleAndMilesGreaterThan(String title, Integer miles);
    //trova tutte
    List<Run> findAll();
    boolean existsByTitle(String title);
    boolean existsById(Integer id);
    // Query con conteggio usando jpql
    @Query("SELECT COUNT(r) FROM Run r WHERE r.location = :location")
    Long countByLocation(@Param("location") Location location);
     // Trova la prima corsa per titolo (Optional per sicurezza)
    Optional<Run> findFirstByTitle(String title);
}

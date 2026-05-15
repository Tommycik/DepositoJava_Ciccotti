package com.example.demo.Run.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Max;

//specifica che la classe Run è un oggetto entità e deve corrispondere nel database
@Entity
@Table(name = "runs")  // la tabella si chiamerà "runs" (lowercase, plurale) altrimenti di default RUN
public class Run {
    //specifica che id funge da chiave primaria
    @Id
    //specifica che id è un numero intero auto-incrementato
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Colonna con nome esplicito, non può essere nulla, lunghezza massima 255
    //annotazioni per validazione
    @NotNull(message = "Title is required")
    @Size(min=3,max = 100, message = "Title must be between 3 and 100 characters")
    @Column(name = "title")
    private String title;
    // Colonna  non può essere nulla
    @NotNull(message = "Starting time is required")
    @Column(name = "startedOn")
    private LocalDateTime startedOn;
    // Colonna  non può essere nulla
    @NotNull(message = "Completion time is required")
    @Column(name = "completedOn")
    private LocalDateTime completedOn;
    // Colonna  non può essere nulla
    @Column(name = "miles", nullable = false)
    @Positive(message = "Miles must be a positive number")
    @Max(value = 200, message = "Miles must be less than 200")
    private Integer miles;
    // salva il nome dell'enum come stringa non nulla
    //senza sarebbe salvato come 0 o 1
    @Enumerated(EnumType.STRING)  
    @NotNull(message = "Location is required")
    @Column(name = "location")
    private Location location;
    //costruttore per jpa
    //costruttore effettivo che utilizza
    protected Run() {}

    // costruttore
    //id va tolto
    public Run(String title,LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {

        this.title = title;

        this.startedOn = startedOn;

        this.completedOn = completedOn;

        this.miles = miles;

        this.location = location;

    }


    // Getters

    public Integer getId() {

        return id;

    }


    public String getTitle() {

        return title;

    }

    public LocalDateTime getStartedOn() {

        return startedOn;

    }


    public LocalDateTime getCompletedOn() {

        return completedOn;

    }


    public Integer getMiles() {

        return miles;

    }


    public Location getLocation() {

        return location;

    }


    // Setters

    public void setId(Integer id) {

        this.id = id;

    }


    public void setTitle(String title) {

        this.title = title;

    }


    public void setStartedOn(LocalDateTime startedOn) {

        this.startedOn = startedOn;

    }

    public void setCompletedOn(LocalDateTime completedOn) {

    this.completedOn = completedOn;

    }


    public void setMiles(Integer miles) {

    this.miles = miles;

    }


    public void setLocation(Location location)
    {

        this.location = location;

    }


    // toString method

    @Override

    public String toString() {

        return "Run{" +

        "id=" + id +

        ", title='" + title + '\'' +

        ", startedOn=" + startedOn +

        ", completedOn=" + completedOn +

        ", miles=" + miles +

        ", location=" + location +

        '}';

    }

}
package com.example.demo.Run.Model;

import java.time.LocalDateTime;
//record per la risposta di un run
public record RunResponse (
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    String location 
){}

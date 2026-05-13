package com.example.demo.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record RunRecord (

    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
){
    public RunRecord{
        if(miles < 0){
            miles = 0;
            //throw new IllegalArgumentException("Miles must be greater than 0");
        }
        if(completedOn.isBefore(startedOn)){
            completedOn = startedOn.plus(1,ChronoUnit.HOURS);
            //throw new IllegalArgumentException("Completed on must be after started on");
        }
    }
}

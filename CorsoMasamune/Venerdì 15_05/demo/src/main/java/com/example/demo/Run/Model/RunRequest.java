package com.example.demo.Run.Model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
//record per la creazione di un nuovo run come richiesta
public record RunRequest (
    //niente id in quanto non utilizzato dalle richiest
    @NotBlank(message = "Title is required")
    String title,
    @NotNull(message = "Starting time is required")
    LocalDateTime startedOn,
    @NotNull(message = "Completion time is required")
    LocalDateTime completedOn,
    @NotNull(message = "Miles is required")
    @Positive(message = "Miles must be a positive number")
    Integer miles,
    @NotNull(message = "Location is required")
    Location location
){}

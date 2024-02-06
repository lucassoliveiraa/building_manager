package com.lucasoliveira.buildingmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record PersonDTO(UUID id, @NotNull LocalDate dateOfBirth, @NotBlank Character sex){
}

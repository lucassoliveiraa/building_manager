package com.lucasoliveira.buildingmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record BuildingDTO(UUID id, @NotBlank String address, @NotNull LocalDate constructionDate, @NotNull LocalDate dateOfLastVisit) {

}

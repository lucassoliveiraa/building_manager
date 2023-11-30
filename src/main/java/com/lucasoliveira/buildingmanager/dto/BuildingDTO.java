package com.lucasoliveira.buildingmanager.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BuildingDTO(UUID id, String address, LocalDate constructionDate, LocalDate dateOfLastVisit) {

}

package com.lucasoliveira.buildingmanager.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ApartamentDTO(UUID id, Integer number, BigDecimal area, BigDecimal amount) {
}

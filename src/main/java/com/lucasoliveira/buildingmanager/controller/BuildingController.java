package com.lucasoliveira.buildingmanager.controller;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.dto.MessageResponseDTO;
import com.lucasoliveira.buildingmanager.entity.Building;
import com.lucasoliveira.buildingmanager.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid BuildingDTO buildingDTO) {
        return buildingService.create(buildingDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return buildingService.findById(id);
    }

    @GetMapping
    public List<BuildingDTO> findAll() {
        return buildingService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return buildingService.delete(id);
    }
}

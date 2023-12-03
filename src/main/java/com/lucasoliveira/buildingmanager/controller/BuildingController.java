package com.lucasoliveira.buildingmanager.controller;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.dto.MessageResponseDTO;
import com.lucasoliveira.buildingmanager.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping()
    public MessageResponseDTO create(@RequestBody BuildingDTO buildingDTO) {
        return buildingService.create(buildingDTO);
    }

    @GetMapping("/{id}")
    public BuildingDTO findById(@PathVariable UUID id) {
        return buildingService.findById(id);
    }

    @GetMapping
    public List<BuildingDTO> findAll() {
        return buildingService.findAll();
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO delete(@PathVariable UUID id) {
        return buildingService.delete(id);
    }
}

package com.lucasoliveira.buildingmanager.service;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.dto.MessageResponseDTO;
import com.lucasoliveira.buildingmanager.entity.Building;
import com.lucasoliveira.buildingmanager.mapper.IBuildingMapper;
import com.lucasoliveira.buildingmanager.repository.IBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BuildingService {
    @Autowired
    private IBuildingRepository repository;

    private final IBuildingMapper buildingMapper = IBuildingMapper.INSTANCE;
    public ResponseEntity<?> create(BuildingDTO buildingDTO) {
        Building buildingToSave = buildingMapper.toModel(buildingDTO);
        Building saveBuilding = repository.save(buildingToSave);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Success! Building created: " + saveBuilding);
    }

    public ResponseEntity<?> delete(UUID id) {
        ResponseEntity<?> deletedBuilding = findById(id);
        repository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Success! Building deleted: " + deletedBuilding);
    }
    public ResponseEntity<?> findById(UUID id) {
        Building building = repository.findById(id).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Building not found")
        );
        BuildingDTO buildingDTO = buildingMapper.toDTO(building);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body("Success! Building find: " + building);
    }

    public List<BuildingDTO> findAll() {
        List<Building> listBuildings = repository.findAll();
        if (!listBuildings.isEmpty()) {
            return buildingMapper.toDTO(listBuildings);
        }
        return null;
    }
}

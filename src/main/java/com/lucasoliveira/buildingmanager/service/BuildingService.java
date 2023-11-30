package com.lucasoliveira.buildingmanager.service;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.dto.MessageResponseDTO;
import com.lucasoliveira.buildingmanager.entity.Building;
import com.lucasoliveira.buildingmanager.mapper.IBuildingMapper;
import com.lucasoliveira.buildingmanager.repository.IBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BuildingService {
    @Autowired
    private IBuildingRepository repository;

    private final IBuildingMapper buildingMapper = IBuildingMapper.INSTANCE;
    public MessageResponseDTO create(BuildingDTO buildingDTO) {
        Building buildingToSave = buildingMapper.toModel(buildingDTO);
        Building saveBuilding = repository.save(buildingToSave);
        return MessageResponseDTO.builder()
                .message("Building created with ID: " + saveBuilding)
                .build();
    }

    public BuildingDTO findById(UUID id) {
        Optional<Building> optionalBuilding = repository.findById(id);
        if(optionalBuilding.isPresent()) {
            return buildingMapper.toDTO(optionalBuilding.get());
        }
        return null;
    }

    public List<BuildingDTO> findAll() {
        List<Building> listBuildings = repository.findAll();
        if (!listBuildings.isEmpty()) {
            return buildingMapper.toDTO();
        }
        return null;
    }
}

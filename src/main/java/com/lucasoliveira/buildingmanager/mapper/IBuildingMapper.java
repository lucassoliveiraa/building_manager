package com.lucasoliveira.buildingmanager.mapper;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper

public interface IBuildingMapper {

    IBuildingMapper INSTANCE = Mappers.getMapper(IBuildingMapper.class);
    Building toModel(BuildingDTO buildingDTO);
    BuildingDTO toDTO(Building building);
    default List<BuildingDTO> toDTO(List<Building> buildings) {
        List<BuildingDTO> listWithBuildingsDTO = new ArrayList<BuildingDTO>();
        Iterator<Building> buildingIterator = buildings.iterator();
        while (buildingIterator.hasNext()) {
            listWithBuildingsDTO.add(toDTO(buildingIterator.next()));
        }
        return listWithBuildingsDTO;
    }
}

package com.lucasoliveira.buildingmanager.mapper;

import com.lucasoliveira.buildingmanager.dto.BuildingDTO;
import com.lucasoliveira.buildingmanager.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper

public interface IBuildingMapper {

    IBuildingMapper INSTANCE = Mappers.getMapper(IBuildingMapper.class);
    Building toModel(BuildingDTO buildingDTO);
    BuildingDTO toDTO(Building building);
}

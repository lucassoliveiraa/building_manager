package com.lucasoliveira.buildingmanager.repository;

import com.lucasoliveira.buildingmanager.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IBuildingRepository extends JpaRepository<Building, UUID> {
}

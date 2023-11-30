package com.lucasoliveira.buildingmanager.repository;

import com.lucasoliveira.buildingmanager.entity.Apartament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IApartamentRepository extends JpaRepository<Apartament, UUID> {
}

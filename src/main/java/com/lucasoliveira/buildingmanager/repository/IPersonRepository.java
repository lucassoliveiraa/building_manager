package com.lucasoliveira.buildingmanager.repository;

import com.lucasoliveira.buildingmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPersonRepository extends JpaRepository<Person, UUID> {
}

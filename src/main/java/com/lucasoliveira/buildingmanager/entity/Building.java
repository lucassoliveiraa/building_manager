package com.lucasoliveira.buildingmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String address;

    @Column(name = "construction_date", nullable = false)
    private LocalDate constructionDate;

    @Column(name = "date_of_last_visit", nullable = false)
    private LocalDate dateOfLastVisit;

    @OneToMany(mappedBy = "atTheBuilding")
    private Set<Apartament> apartments = new HashSet<>();
}

package com.lucasoliveira.buildingmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apartament {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private BigDecimal area;

    @Column(nullable = false)
    private BigDecimal amount;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building atTheBuilding;

}

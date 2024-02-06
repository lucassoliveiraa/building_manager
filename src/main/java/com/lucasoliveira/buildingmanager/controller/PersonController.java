package com.lucasoliveira.buildingmanager.controller;

import com.lucasoliveira.buildingmanager.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid PersonService personDTO){
        return personService.create(personDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findyById(@PathVariable UUID id) {
        return personService.findById(id);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return personService.findAll();
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return personService.delete(id);
    }

}

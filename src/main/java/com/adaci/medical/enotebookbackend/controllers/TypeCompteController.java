package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.models.TypeCompte;
import com.adaci.medical.enotebookbackend.services.TypeCompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(name = "User APi", value = "api/v1/type-compte")
public class TypeCompteController {

    private TypeCompteService typeCompteService;

    @Autowired
    public TypeCompteController(TypeCompteService typeCompteService) {
        this.typeCompteService = typeCompteService;
    }

    @GetMapping()
    private ResponseEntity<List<TypeCompte>> getAll() {
        return ResponseEntity.ok(typeCompteService.findAll());
    }
}

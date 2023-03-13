package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.TypeEtablissement;
import com.adaci.medical.enotebookbackend.services.TypeEtablissementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Type Etablissement Api", value = "api/v1/type-etablissement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeEtablissementController {
    private final TypeEtablissementService typeEtablissementService;

    @Autowired
    public TypeEtablissementController(TypeEtablissementService typeEtablissementService) {
        this.typeEtablissementService = typeEtablissementService;
    }

    @PostMapping()
    public ResponseEntity<TypeEtablissement> create(@Valid @RequestBody TypeEtablissement typeEtablissement) {
        try {
            typeEtablissement.setLibelle(typeEtablissement.getLibelle().toUpperCase());
            typeEtablissement.setNomSimplifie(typeEtablissement.getNomSimplifie().toUpperCase());
            return new ResponseEntity<TypeEtablissement>(typeEtablissementService.create(typeEtablissement), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<TypeEtablissement>((TypeEtablissement) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<TypeEtablissement>> getAll() {
        try {
            return ResponseEntity.ok(typeEtablissementService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<TypeEtablissement>>((List<TypeEtablissement>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEtablissement> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(typeEtablissementService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<TypeEtablissement> update(@Valid @RequestBody TypeEtablissement typeEtablissement) throws ResourceNotFoundException {
        TypeEtablissement typeEtablissementGet = typeEtablissementService.findById(typeEtablissement.getId());
        if (typeEtablissementGet != null) {
            typeEtablissement.setLibelle(typeEtablissement.getLibelle().toUpperCase());
            typeEtablissement.setNomSimplifie(typeEtablissement.getNomSimplifie().toUpperCase());
            return ResponseEntity.ok(typeEtablissementService.update(typeEtablissement));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        TypeEtablissement typeEtablissementGet = typeEtablissementService.findById(id);
        if (typeEtablissementGet != null) {
            typeEtablissementService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody TypeEtablissement typeEtablissement) throws ResourceNotFoundException {
        TypeEtablissement typeEtablissementGet = typeEtablissementService.findById(typeEtablissement.getId());
        if (typeEtablissementGet != null) {
            typeEtablissementService.delete(typeEtablissement);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}

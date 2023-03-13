package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Specialite;
import com.adaci.medical.enotebookbackend.services.SpecialiteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Specialite Api", value = "api/v1/specialite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpecialiteController {
    private final SpecialiteService specialiteService;

    @Autowired
    public SpecialiteController(SpecialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @PostMapping()
    public ResponseEntity<Specialite> create(@Valid @RequestBody Specialite specialite) {
        try {
            specialite.setLibelle(specialite.getLibelle().toUpperCase());
            return new ResponseEntity<Specialite>(specialiteService.create(specialite), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<Specialite>((Specialite) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Specialite>> getAll() {
        try {
            return ResponseEntity.ok(specialiteService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<Specialite>>((List<Specialite>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(specialiteService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Specialite> update(@Valid @RequestBody Specialite specialite) throws ResourceNotFoundException {
        Specialite specialiteGet = specialiteService.findById(specialite.getId());
        if (specialiteGet != null) {
            specialite.setLibelle(specialite.getLibelle().toUpperCase());
            return ResponseEntity.ok(specialiteService.update(specialite));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        Specialite specialiteGet = specialiteService.findById(id);
        if (specialiteGet != null) {
            specialiteService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody Specialite specialite) throws ResourceNotFoundException {
        Specialite specialiteGet = specialiteService.findById(specialite.getId());
        if (specialiteGet != null) {
            specialiteService.delete(specialite);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}

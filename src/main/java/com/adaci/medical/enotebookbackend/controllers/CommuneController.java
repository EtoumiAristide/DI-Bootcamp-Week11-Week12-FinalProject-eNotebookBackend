package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Commune;
import com.adaci.medical.enotebookbackend.services.CommuneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/commune")
public class CommuneController {
    private final CommuneService communeService;

    @Autowired
    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    @PostMapping()
    public ResponseEntity<Commune> create(@Valid @RequestBody Commune commune) {
        try {
            commune.setNom(commune.getNom().toUpperCase());
            return new ResponseEntity<Commune>(communeService.create(commune), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<Commune>((Commune) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Commune>> getAll() {
        try {
            return ResponseEntity.ok(communeService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<Commune>>((List<Commune>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commune> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(communeService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Commune> update(@Valid @RequestBody Commune commune) throws ResourceNotFoundException {
        Commune CommuneGet = communeService.findById(commune.getId());
        if (CommuneGet != null) {
            commune.setNom(commune.getNom().toUpperCase());
            return ResponseEntity.ok(communeService.update(commune));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        Commune CommuneGet = communeService.findById(id);
        if (CommuneGet != null) {
            communeService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody Commune commune) throws ResourceNotFoundException {
        Commune CommuneGet = communeService.findById(commune.getId());
        if (CommuneGet != null) {
            communeService.delete(commune);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

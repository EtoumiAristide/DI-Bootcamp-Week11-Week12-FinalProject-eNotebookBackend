package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Ville;
import com.adaci.medical.enotebookbackend.services.VilleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Ville Api", value = "api/v1/ville")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @PostMapping()
    public ResponseEntity<Ville> create(@Valid @RequestBody Ville ville) {
        try {
            ville.setNom(ville.getNom().toUpperCase());
            return new ResponseEntity<Ville>(villeService.create(ville), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<Ville>((Ville) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Ville>> getAll() {
        try {
            return ResponseEntity.ok(villeService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<Ville>>((List<Ville>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(villeService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Ville> update(@Valid @RequestBody Ville ville) throws ResourceNotFoundException {
        Ville VilleGet = villeService.findById(ville.getId());
        if (VilleGet != null) {
            ville.setNom(ville.getNom().toUpperCase());
            return ResponseEntity.ok(villeService.update(ville));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        Ville VilleGet = villeService.findById(id);
        if (VilleGet != null) {
            villeService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody Ville Ville) throws ResourceNotFoundException {
        Ville VilleGet = villeService.findById(Ville.getId());
        if (VilleGet != null) {
            villeService.delete(Ville);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}

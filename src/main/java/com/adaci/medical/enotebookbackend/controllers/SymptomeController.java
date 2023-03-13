package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Symptome;
import com.adaci.medical.enotebookbackend.services.SymptomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Symptome Api", value = "api/v1/symptome")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SymptomeController {
    private final SymptomeService symptomeService;

    @Autowired
    public SymptomeController(SymptomeService symptomeService) {
        this.symptomeService = symptomeService;
    }

    @PostMapping()
    public ResponseEntity<Symptome> create(@Valid @RequestBody Symptome symptome) {
        try {
            symptome.setLibelle(symptome.getLibelle().toUpperCase());
            return new ResponseEntity<Symptome>(symptomeService.create(symptome), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<Symptome>((Symptome) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Symptome>> getAll() {
        try {
            return ResponseEntity.ok(symptomeService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<Symptome>>((List<Symptome>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Symptome> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(symptomeService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Symptome> update(@Valid @RequestBody Symptome symptome) throws ResourceNotFoundException {
        Symptome symptomeGet = symptomeService.findById(symptome.getId());
        if (symptomeGet != null) {
            symptome.setLibelle(symptome.getLibelle().toUpperCase());
            return ResponseEntity.ok(symptomeService.update(symptome));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        Symptome symptomeGet = symptomeService.findById(id);
        if (symptomeGet != null) {
            symptomeService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody Symptome symptome) throws ResourceNotFoundException {
        Symptome symptomeGet = symptomeService.findById(symptome.getId());
        if (symptomeGet != null) {
            symptomeService.delete(symptome);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}

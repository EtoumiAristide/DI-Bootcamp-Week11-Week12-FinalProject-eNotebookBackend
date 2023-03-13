package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Pays;
import com.adaci.medical.enotebookbackend.services.PaysService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Pays Api", value = "api/v1/pays")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaysController {
    private final PaysService paysService;

    @Autowired
    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @PostMapping()
    public ResponseEntity<Pays> create(@Valid @RequestBody Pays pays) {
        try {
            pays.setNom(pays.getNom().toUpperCase());
            return new ResponseEntity<Pays>(paysService.create(pays), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<Pays>((Pays) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Pays>> getAll() {
        try {
            return ResponseEntity.ok(paysService.findAll());
        } catch (Exception ex) {
            return new ResponseEntity<List<Pays>>((List<Pays>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pays> getById(@Valid @PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(paysService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Pays> update(@Valid @RequestBody Pays pays) throws ResourceNotFoundException {
        Pays paysGet = paysService.findById(pays.getId());
        if (paysGet != null) {
            pays.setNom(pays.getNom().toUpperCase());
            return ResponseEntity.ok(paysService.update(pays));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) throws ResourceNotFoundException {
        Pays paysGet = paysService.findById(id);
        if (paysGet != null) {
            paysService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestBody Pays pays) throws ResourceNotFoundException {
        Pays paysGet = paysService.findById(pays.getId());
        if (paysGet != null) {
            paysService.delete(pays);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}

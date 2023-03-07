package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.models.Commune;
import com.adaci.medical.enotebookbackend.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commune")
public class CommuneController {
    @Autowired
    private CommuneService communeService;

    @PostMapping
    public ResponseEntity<Commune> createCommune(@RequestBody Commune commune) {
        return ResponseEntity.ok(communeService.create(commune));
    }
}

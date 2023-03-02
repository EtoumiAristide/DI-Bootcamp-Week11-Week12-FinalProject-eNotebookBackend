package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(name = "User APi", value = "api/v1/users")
public class CompteUtilisateurController {
    @PostMapping("/login")
    private void login(@Valid @RequestBody CompteUtilisateur compteUtilisateur) {

    }

    @PostMapping("/register")
    private void register(@RequestBody CompteUtilisateur compteUtilisateur) {

    }

    @PostMapping("/logout")
    private void logout(@RequestBody CompteUtilisateur compteUtilisateur) {

    }
}

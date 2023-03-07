package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.models.RegisterData;
import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import com.adaci.medical.enotebookbackend.models.Patient;
import com.adaci.medical.enotebookbackend.services.CompteUtilisateurService;
import com.adaci.medical.enotebookbackend.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(name = "User APi", value = "api/v1/users")
public class CompteUtilisateurController {

    @Autowired
    private CompteUtilisateurService compteUtilisateurService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/login")
    private ResponseEntity<CompteUtilisateur> login(@RequestBody @Valid RegisterData registerData) throws ResourceNotFoundException {
        return ResponseEntity.ok(compteUtilisateurService.connexionUtilisateur(registerData.getLogin(), registerData.getPassword()));
    }

    @PostMapping("/register")
    private ResponseEntity<CompteUtilisateur> register(@RequestBody @Valid RegisterData registerData) {
        try {
            //Creation du patient
            Patient patient = new Patient();
            patient.setNom(registerData.getNom());
            patient.setPrenoms(registerData.getPrenom());
            patient.setTel1(registerData.getTel());
            Patient patientCreate = patientService.create(patient);

            //Creation du compte utilisateur
            CompteUtilisateur compteUtilisateur = new CompteUtilisateur();
            compteUtilisateur.setLogin(registerData.getLogin());
            compteUtilisateur.setPassword(registerData.getPassword());
            compteUtilisateur.setTypeCompte(registerData.getTypeCompte());
            compteUtilisateur.setPersonne(patientCreate);

            return new ResponseEntity<>(compteUtilisateurService.create(compteUtilisateur), HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @PostMapping("/logout")
    private void logout(@RequestBody CompteUtilisateur compteUtilisateur) {

    }
}

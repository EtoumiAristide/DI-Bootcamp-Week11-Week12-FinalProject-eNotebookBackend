package com.adaci.medical.enotebookbackend.controllers;

import com.adaci.medical.enotebookbackend.payloads.LoginDataPayload;
import com.adaci.medical.enotebookbackend.payloads.RegisterDataPayload;
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

    private final CompteUtilisateurService compteUtilisateurService;

    private final PatientService patientService;

    @Autowired
    public CompteUtilisateurController(CompteUtilisateurService compteUtilisateurService, PatientService patientService) {
        this.compteUtilisateurService = compteUtilisateurService;
        this.patientService = patientService;
    }

    @PostMapping("/login")
    private ResponseEntity<CompteUtilisateur> login(@RequestBody @Valid LoginDataPayload loginDataPayload) throws ResourceNotFoundException {
        return ResponseEntity.ok(compteUtilisateurService.connexionUtilisateur(loginDataPayload.getLogin(), loginDataPayload.getPassword()));
    }

    @PostMapping("/register")
    private ResponseEntity<CompteUtilisateur> register(@RequestBody @Valid RegisterDataPayload registerDataPayload) {
        try {
            //Creation du patient
            Patient patient = new Patient();
            patient.setNom(registerDataPayload.getNom());
            patient.setPrenoms(registerDataPayload.getPrenom());
            patient.setTel1(registerDataPayload.getTel());
            Patient patientCreate = patientService.create(patient);

            //Creation du compte utilisateur
            CompteUtilisateur compteUtilisateur = new CompteUtilisateur();
            compteUtilisateur.setLogin(registerDataPayload.getLogin());
            compteUtilisateur.setPassword(registerDataPayload.getPassword());
            compteUtilisateur.setTypeCompte(registerDataPayload.getTypeCompte());
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

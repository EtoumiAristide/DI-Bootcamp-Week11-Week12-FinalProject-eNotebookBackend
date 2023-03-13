package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.enums.CompteType;
import com.adaci.medical.enotebookbackend.enums.SessionType;
import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import com.adaci.medical.enotebookbackend.models.Medecin;
import com.adaci.medical.enotebookbackend.models.Patient;
import com.adaci.medical.enotebookbackend.models.SessionUtilisateur;
import com.adaci.medical.enotebookbackend.repositories.CompteUtilisateurRepository;
import com.adaci.medical.enotebookbackend.repositories.MedecinRepository;
import com.adaci.medical.enotebookbackend.repositories.PatientRepository;
import com.adaci.medical.enotebookbackend.repositories.SessionUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteUtilisateurService implements ApiContract<CompteUtilisateur> {

    private final CompteUtilisateurRepository compteUtilisateurRepository;
    private final SessionUtilisateurService sessionUtilisateurService;
    private final MedecinService medecinService;
    private final PatientService patientService;

    @Autowired
    public CompteUtilisateurService(CompteUtilisateurRepository compteUtilisateurRepository, SessionUtilisateurService sessionUtilisateurService, MedecinService medecinService, PatientService patientService) {
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.sessionUtilisateurService = sessionUtilisateurService;
        this.medecinService = medecinService;
        this.patientService = patientService;
    }


    @Override
    public List<CompteUtilisateur> findAll() {
        return compteUtilisateurRepository.findAll();
    }

    @Override
    public CompteUtilisateur findById(long id) throws ResourceNotFoundException {
        Optional<CompteUtilisateur> compteUtilisateur = compteUtilisateurRepository.findById(id);
        if (compteUtilisateur.isPresent()) {
            return compteUtilisateur.get();
        } else {
            throw new ResourceNotFoundException("Compte utilisateur non disponible avec l'id : " + id);
        }
    }

    @Override
    public CompteUtilisateur create(CompteUtilisateur compteUtilisateur) {
        return compteUtilisateurRepository.save(compteUtilisateur);
    }

    @Override
    public CompteUtilisateur update(CompteUtilisateur compteUtilisateur) {
        return compteUtilisateurRepository.save(compteUtilisateur);
    }

    @Override
    public void delete(CompteUtilisateur compteUtilisateur) {
        compteUtilisateurRepository.delete(compteUtilisateur);
    }

    @Override
    public void delete(long id) {
        compteUtilisateurRepository.deleteById(id);
    }

    public CompteUtilisateur connexionUtilisateur(String login, String password) throws ResourceNotFoundException {
        Optional<CompteUtilisateur> compteUtilisateur = compteUtilisateurRepository.findByLoginAndPassword(login, password);

        if (compteUtilisateur.isPresent()) {
            CompteUtilisateur compteUtilisateurData = compteUtilisateur.get();
            //On créé la session utilisateur
            SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(SessionType.CONNECTED);
            sessionUtilisateur.setCompteUtilisateur(compteUtilisateur.get());
            sessionUtilisateurService.create(sessionUtilisateur);

            //Assignation des informations de la personne
            CompteType compteType = compteUtilisateurData.getTypeCompte().getLibelle();
            switch (compteType) {
                case MEDECIN:
                    Medecin medecin = medecinService.findById(compteUtilisateurData.getPersonne().getId());
                    compteUtilisateurData.setPersonne(medecin);
                    break;
                case PATIENT:
                    Patient patient = patientService.findById(compteUtilisateurData.getPersonne().getId());
                    compteUtilisateurData.setPersonne(patient);
                    break;
                case ADMINISTRATEUR:
                    break;
            }

            return compteUtilisateurData;

        } else {
            throw new ResourceNotFoundException("Compte utilisateur non trouvé");
        }
    }

    public CompteUtilisateur deconnexionUtilisateur(long id) throws ResourceNotFoundException {
        Optional<CompteUtilisateur> compteUtilisateur = compteUtilisateurRepository.findById(id);


        if (compteUtilisateur.isPresent()) {
            //On créé la session utilisateur
            SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(SessionType.DISCONNECTED);
            sessionUtilisateur.setCompteUtilisateur(compteUtilisateur.get());
            sessionUtilisateurService.create(sessionUtilisateur);

            return compteUtilisateur.get();

        } else {
            throw new ResourceNotFoundException("Compte utilisateur non trouvé");
        }
    }
}

package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.enums.SessionType;
import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import com.adaci.medical.enotebookbackend.models.SessionUtilisateur;
import com.adaci.medical.enotebookbackend.repositories.CompteUtilisateurRepository;
import com.adaci.medical.enotebookbackend.repositories.SessionUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteUtilisateurService implements ApiContract<CompteUtilisateur> {

    private final CompteUtilisateurRepository compteUtilisateurRepository;
    private final SessionUtilisateurRepository sessionUtilisateurRepository;

    @Autowired
    public CompteUtilisateurService(CompteUtilisateurRepository compteUtilisateurRepository, SessionUtilisateurRepository sessionUtilisateurRepository) {
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.sessionUtilisateurRepository = sessionUtilisateurRepository;
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
            //On créé la session utilisateur
            SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(SessionType.CONNECTED);
            sessionUtilisateurRepository.save(sessionUtilisateur);
            return compteUtilisateur.get();

        } else {
            throw new ResourceNotFoundException("Compte utilisateur non trouvé");
        }
    }

    public CompteUtilisateur deconnexionUtilisateur(long id) throws ResourceNotFoundException {
        Optional<CompteUtilisateur> compteUtilisateur = compteUtilisateurRepository.findById(id);


        if (compteUtilisateur.isPresent()) {
            //On créé la session utilisateur
            SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(SessionType.DISCONNECTED);
            sessionUtilisateurRepository.save(sessionUtilisateur);

            return compteUtilisateur.get();

        } else {
            throw new ResourceNotFoundException("Compte utilisateur non trouvé");
        }
    }
}

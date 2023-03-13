package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Pays;
import com.adaci.medical.enotebookbackend.models.SessionUtilisateur;
import com.adaci.medical.enotebookbackend.repositories.SessionUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionUtilisateurService implements ApiContract<SessionUtilisateur> {
    private final SessionUtilisateurRepository sessionUtilisateurRepository;

    @Autowired
    public SessionUtilisateurService(SessionUtilisateurRepository sessionUtilisateurRepository) {
        this.sessionUtilisateurRepository = sessionUtilisateurRepository;
    }

    @Override
    public List<SessionUtilisateur> findAll() {
        return sessionUtilisateurRepository.findAll();
    }

    @Override
    public SessionUtilisateur findById(long id) throws ResourceNotFoundException {
        Optional<SessionUtilisateur> sessionUtilisateur = sessionUtilisateurRepository.findById(id);
        if (sessionUtilisateur.isPresent()) {
            return sessionUtilisateur.get();
        } else {
            throw new ResourceNotFoundException("Session Utilisateur non disponible avec l'id : " + id);
        }
    }

    @Override
    public SessionUtilisateur create(SessionUtilisateur sessionUtilisateur) {
        return sessionUtilisateurRepository.save(sessionUtilisateur);
    }

    @Override
    public SessionUtilisateur update(SessionUtilisateur sessionUtilisateur) {
        return sessionUtilisateurRepository.save(sessionUtilisateur);
    }

    @Override
    public void delete(SessionUtilisateur sessionUtilisateur) {
        sessionUtilisateurRepository.delete(sessionUtilisateur);
    }

    @Override
    public void delete(long id) {
        sessionUtilisateurRepository.deleteById(id);
    }
}

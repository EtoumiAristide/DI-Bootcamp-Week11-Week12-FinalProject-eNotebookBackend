package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long> {

    public Optional<CompteUtilisateur> findByLoginAndPassword(String login, String password);
}

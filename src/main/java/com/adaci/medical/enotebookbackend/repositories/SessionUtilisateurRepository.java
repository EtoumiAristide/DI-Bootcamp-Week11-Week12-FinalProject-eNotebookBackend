package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.SessionUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionUtilisateurRepository extends JpaRepository<SessionUtilisateur, Long> {
}

package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long> {

    @Query("SELECT c FROM CompteUtilisateur c WHERE c.login = :login AND c.password = :password")
    public Optional<CompteUtilisateur> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}

package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {
}

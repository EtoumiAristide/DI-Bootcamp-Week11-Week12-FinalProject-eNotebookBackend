package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.OrdonnanceMaladie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdonnanceMaladieRepository extends JpaRepository<OrdonnanceMaladie, Long> {
}

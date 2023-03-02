package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {
}

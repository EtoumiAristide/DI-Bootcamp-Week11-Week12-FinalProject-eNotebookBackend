package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Symptome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomeRepository extends JpaRepository<Symptome, Long> {
}

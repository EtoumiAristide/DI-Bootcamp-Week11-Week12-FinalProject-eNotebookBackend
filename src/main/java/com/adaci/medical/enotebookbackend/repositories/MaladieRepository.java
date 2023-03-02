package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaladieRepository extends JpaRepository<Maladie, Long> {
}

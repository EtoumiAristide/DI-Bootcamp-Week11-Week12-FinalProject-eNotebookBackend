package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}

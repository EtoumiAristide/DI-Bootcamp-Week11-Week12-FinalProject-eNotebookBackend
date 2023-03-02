package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}

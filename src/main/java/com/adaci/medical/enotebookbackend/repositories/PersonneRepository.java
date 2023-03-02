package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonneRepository<T, ID> extends JpaRepository<Personne, Long> {

}

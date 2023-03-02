package com.adaci.medical.enotebookbackend.repositories;

import com.adaci.medical.enotebookbackend.models.Physique;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PhysiqueRepository<T, ID> extends PersonneRepository<Physique, Long> {
}

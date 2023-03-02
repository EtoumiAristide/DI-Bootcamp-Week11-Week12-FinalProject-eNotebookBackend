package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.SpecialiteEtablissement;
import com.adaci.medical.enotebookbackend.repositories.SpecialiteEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteEtablissementService implements ApiContract<SpecialiteEtablissement> {

    private SpecialiteEtablissementRepository specialiteEtablissementRepository;

    @Autowired
    public SpecialiteEtablissementService(SpecialiteEtablissementRepository specialiteEtablissementRepository) {
        this.specialiteEtablissementRepository = specialiteEtablissementRepository;
    }

    @Override
    public List<SpecialiteEtablissement> findAll() {
        return specialiteEtablissementRepository.findAll();
    }

    @Override
    public SpecialiteEtablissement findById(long id) throws ResourceNotFoundException {
        Optional<SpecialiteEtablissement> specialiteEtablissement = specialiteEtablissementRepository.findById(id);
        if (specialiteEtablissement.isPresent()) {
            return specialiteEtablissement.get();
        } else {
            throw new ResourceNotFoundException("Specialite-Etablissement non disponible avec l'id : " + id);
        }
    }

    @Override
    public SpecialiteEtablissement create(SpecialiteEtablissement specialiteEtablissement) {
        return specialiteEtablissementRepository.save(specialiteEtablissement);
    }

    @Override
    public SpecialiteEtablissement update(SpecialiteEtablissement specialiteEtablissement) {
        return specialiteEtablissementRepository.save(specialiteEtablissement);
    }

    @Override
    public void delete(SpecialiteEtablissement specialiteEtablissement) {
        specialiteEtablissementRepository.delete(specialiteEtablissement);
    }

    @Override
    public void delete(long id) {
        specialiteEtablissementRepository.deleteById(id);
    }
}

package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Specialite;
import com.adaci.medical.enotebookbackend.repositories.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteService implements ApiContract<Specialite> {

    private final SpecialiteRepository specialiteRepository;

    @Autowired
    public SpecialiteService(SpecialiteRepository specialiteRepository) {
        this.specialiteRepository = specialiteRepository;
    }

    @Override
    public List<Specialite> findAll() {
        return specialiteRepository.findAll();
    }

    @Override
    public Specialite findById(long id) throws ResourceNotFoundException {
        Optional<Specialite> specialite = specialiteRepository.findById(id);
        if (specialite.isPresent()) {
            return specialite.get();
        } else {
            throw new ResourceNotFoundException("Spécialité non disponible avec l'id : " + id);
        }
    }

    @Override
    public Specialite create(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public Specialite update(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public void delete(Specialite specialite) {
        specialiteRepository.delete(specialite);
    }

    @Override
    public void delete(long id) {
        specialiteRepository.deleteById(id);
    }
}

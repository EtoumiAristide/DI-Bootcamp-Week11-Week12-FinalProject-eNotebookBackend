package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Commune;
import com.adaci.medical.enotebookbackend.repositories.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommuneService implements ApiContract<Commune> {
    private final CommuneRepository communeRepository;

    @Autowired
    public CommuneService(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    @Override
    public List<Commune> findAll() {
        return communeRepository.findAll();
    }

    @Override
    public Commune findById(long id) throws ResourceNotFoundException {
        Optional<Commune> commune = communeRepository.findById(id);
        if (commune.isPresent()) {
            return commune.get();
        } else {
            throw new ResourceNotFoundException("Commune non disponible avec l'id : " + id);
        }
    }

    @Override
    public Commune create(Commune commune) {
        return communeRepository.save(commune);
    }

    @Override
    public Commune update(Commune commune) {
        return communeRepository.save(commune);
    }

    @Override
    public void delete(Commune commune) {
        communeRepository.delete(commune);
    }

    @Override
    public void delete(long id) {
        communeRepository.deleteById(id);
    }
}

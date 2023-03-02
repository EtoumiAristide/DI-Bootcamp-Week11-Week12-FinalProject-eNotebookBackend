package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Ordonnance;
import com.adaci.medical.enotebookbackend.repositories.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdonnanceService implements ApiContract<Ordonnance> {

    private final OrdonnanceRepository ordonnanceRepository;

    @Autowired
    public OrdonnanceService(OrdonnanceRepository ordonnanceRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
    }

    @Override
    public List<Ordonnance> findAll() {
        return ordonnanceRepository.findAll();
    }

    @Override
    public Ordonnance findById(long id) throws ResourceNotFoundException {
        Optional<Ordonnance> ordonnance = ordonnanceRepository.findById(id);
        if (ordonnance.isPresent()) {
            return ordonnance.get();
        } else {
            throw new ResourceNotFoundException("Ordonnance non disponible avec l'id : " + id);
        }
    }

    @Override
    public Ordonnance create(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    @Override
    public Ordonnance update(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    @Override
    public void delete(Ordonnance ordonnance) {
        ordonnanceRepository.delete(ordonnance);
    }

    @Override
    public void delete(long id) {
        ordonnanceRepository.deleteById(id);
    }
}

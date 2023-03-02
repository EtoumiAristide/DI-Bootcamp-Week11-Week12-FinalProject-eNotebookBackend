package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Symptome;
import com.adaci.medical.enotebookbackend.repositories.SymptomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomeService implements ApiContract<Symptome> {

    private final SymptomeRepository symptomeRepository;

    @Autowired
    public SymptomeService(SymptomeRepository symptomeRepository) {
        this.symptomeRepository = symptomeRepository;
    }

    @Override
    public List<Symptome> findAll() {
        return symptomeRepository.findAll();
    }

    @Override
    public Symptome findById(long id) throws ResourceNotFoundException {
        Optional<Symptome> symptome = symptomeRepository.findById(id);
        if (symptome.isPresent()) {
            return symptome.get();
        } else {
            throw new ResourceNotFoundException("Symptome non disponible avec l'id : " + id);
        }
    }

    @Override
    public Symptome create(Symptome symptome) {
        return symptomeRepository.save(symptome);
    }

    @Override
    public Symptome update(Symptome symptome) {
        return symptomeRepository.save(symptome);
    }

    @Override
    public void delete(Symptome symptome) {
        symptomeRepository.delete(symptome);
    }

    @Override
    public void delete(long id) {
        symptomeRepository.deleteById(id);
    }
}

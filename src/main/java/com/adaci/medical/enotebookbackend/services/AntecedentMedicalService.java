package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.AntecedentMedical;
import com.adaci.medical.enotebookbackend.repositories.AntecedentMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedentMedicalService implements ApiContract<AntecedentMedical> {

    private final AntecedentMedicalRepository antecedentMedicalRepository;

    @Autowired
    public AntecedentMedicalService(AntecedentMedicalRepository antecedentMedicalRepository) {
        this.antecedentMedicalRepository = antecedentMedicalRepository;
    }

    @Override
    public List<AntecedentMedical> findAll() {
        return antecedentMedicalRepository.findAll();
    }

    @Override
    public AntecedentMedical findById(long id) throws ResourceNotFoundException {
        Optional<AntecedentMedical> antecedentMedical = antecedentMedicalRepository.findById(id);
        if (antecedentMedical.isPresent()) {
            return antecedentMedical.get();
        } else {
            throw new ResourceNotFoundException("Antecedent médical non disponible avec l'id : " + id);
        }
    }

    @Override
    public AntecedentMedical create(AntecedentMedical antecedentMedical) {
        return antecedentMedicalRepository.save(antecedentMedical);
    }

    @Override
    public AntecedentMedical update(AntecedentMedical antecedentMedical) {
        return antecedentMedicalRepository.save(antecedentMedical);
    }

    @Override
    public void delete(AntecedentMedical antecedentMedical) {
        antecedentMedicalRepository.delete(antecedentMedical);
    }

    @Override
    public void delete(long id) {
        antecedentMedicalRepository.deleteById(id);
    }
}

package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.OrdonnanceMaladie;
import com.adaci.medical.enotebookbackend.repositories.OrdonnanceMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdonnanceMaladieService implements ApiContract<OrdonnanceMaladie> {

    private OrdonnanceMaladieRepository ordonnanceMaladieRepository;

    @Autowired
    public OrdonnanceMaladieService(OrdonnanceMaladieRepository ordonnanceMaladieRepository) {
        this.ordonnanceMaladieRepository = ordonnanceMaladieRepository;
    }

    @Override
    public List<OrdonnanceMaladie> findAll() {
        return ordonnanceMaladieRepository.findAll();
    }

    @Override
    public OrdonnanceMaladie findById(long id) throws ResourceNotFoundException {
        Optional<OrdonnanceMaladie> ordonnanceMaladie = ordonnanceMaladieRepository.findById(id);
        if (ordonnanceMaladie.isPresent()) {
            return ordonnanceMaladie.get();
        } else {
            throw new ResourceNotFoundException("Ordonnance-maladie non disponible avec l'id : " + id);
        }
    }

    @Override
    public OrdonnanceMaladie create(OrdonnanceMaladie ordonnanceMaladie) {
        return ordonnanceMaladieRepository.save(ordonnanceMaladie);
    }

    @Override
    public OrdonnanceMaladie update(OrdonnanceMaladie ordonnanceMaladie) {
        return ordonnanceMaladieRepository.save(ordonnanceMaladie);
    }

    @Override
    public void delete(OrdonnanceMaladie ordonnanceMaladie) {
        ordonnanceMaladieRepository.delete(ordonnanceMaladie);
    }

    @Override
    public void delete(long id) {
        ordonnanceMaladieRepository.deleteById(id);
    }
}

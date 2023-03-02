package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Traitement;
import com.adaci.medical.enotebookbackend.repositories.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementService implements ApiContract<Traitement> {

    private final TraitementRepository traitementRepository;

    @Autowired
    public TraitementService(TraitementRepository traitementRepository) {
        this.traitementRepository = traitementRepository;
    }


    @Override
    public List<Traitement> findAll() {
        return traitementRepository.findAll();
    }

    @Override
    public Traitement findById(long id) throws ResourceNotFoundException {
        Optional<Traitement> traitement = traitementRepository.findById(id);
        if (traitement.isPresent()) {
            return traitement.get();
        } else {
            throw new ResourceNotFoundException("Traitement non disponible avec l'id : " + id);
        }
    }

    @Override
    public Traitement create(Traitement traitement) {
        return traitementRepository.save(traitement);
    }

    @Override
    public Traitement update(Traitement traitement) {
        return traitementRepository.save(traitement);
    }

    @Override
    public void delete(Traitement traitement) {
        traitementRepository.delete(traitement);
    }

    @Override
    public void delete(long id) {
        traitementRepository.deleteById(id);
    }
}

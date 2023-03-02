package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Ville;
import com.adaci.medical.enotebookbackend.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService implements ApiContract<Ville> {

    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @Override
    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

    @Override
    public Ville findById(long id) throws ResourceNotFoundException {
        Optional<Ville> ville = villeRepository.findById(id);
        if (ville.isPresent()) {
            return ville.get();
        } else {
            throw new ResourceNotFoundException("Ville non disponible avec l'id : " + id);
        }
    }

    @Override
    public Ville create(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public Ville update(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public void delete(Ville ville) {
        villeRepository.delete(ville);
    }

    @Override
    public void delete(long id) {
        villeRepository.deleteById(id);
    }
}

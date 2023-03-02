package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Adresse;
import com.adaci.medical.enotebookbackend.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService implements ApiContract<Adresse> {
    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse findById(long id) throws ResourceNotFoundException {
        Optional<Adresse> adresse = adresseRepository.findById(id);
        if (adresse.isPresent()) {
            return adresse.get();
        } else {
            throw new ResourceNotFoundException("Adresse non disponible avec l'id : " + id);
        }
    }

    @Override
    public Adresse create(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse update(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public void delete(Adresse adresse) {
        adresseRepository.delete(adresse);
    }

    @Override
    public void delete(long id) {
        adresseRepository.deleteById(id);
    }
}

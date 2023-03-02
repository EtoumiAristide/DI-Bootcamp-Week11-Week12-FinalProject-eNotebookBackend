package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Etablissement;
import com.adaci.medical.enotebookbackend.repositories.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService implements ApiContract<Etablissement> {

    private final EtablissementRepository etablissementRepository;

    @Autowired
    public EtablissementService(EtablissementRepository etablissementRepository) {
        this.etablissementRepository = etablissementRepository;
    }

    @Override
    public List<Etablissement> findAll() {
        return etablissementRepository.findAll();
    }

    @Override
    public Etablissement findById(long id) throws ResourceNotFoundException {
        Optional<Etablissement> etablissement = etablissementRepository.findById(id);
        if (etablissement.isPresent()) {
            return etablissement.get();
        } else {
            throw new ResourceNotFoundException("Etablissement non disponible avec l'id : " + id);
        }
    }

    @Override
    public Etablissement create(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public Etablissement update(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public void delete(Etablissement etablissement) {
        etablissementRepository.delete(etablissement);
    }

    @Override
    public void delete(long id) {
        etablissementRepository.deleteById(id);
    }
}

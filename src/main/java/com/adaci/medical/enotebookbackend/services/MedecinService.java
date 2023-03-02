package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Medecin;
import com.adaci.medical.enotebookbackend.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService implements ApiContract<Medecin> {

    private final MedecinRepository medecinRepository;

    @Autowired
    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public List<Medecin> findAll() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin findById(long id) throws ResourceNotFoundException {
        Optional<Medecin> medecin = medecinRepository.findById(id);
        if (medecin.isPresent()) {
            return medecin.get();
        } else {
            throw new ResourceNotFoundException("Medecin non disponible avec l'id : " + id);
        }
    }

    @Override
    public Medecin create(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin update(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public void delete(Medecin medecin) {
        medecinRepository.delete(medecin);
    }

    @Override
    public void delete(long id) {
        medecinRepository.deleteById(id);
    }
}

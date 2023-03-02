package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Pays;
import com.adaci.medical.enotebookbackend.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService implements ApiContract<Pays> {

    private final PaysRepository paysRepository;

    @Autowired
    public PaysService(PaysRepository paysRepository) {
        this.paysRepository = paysRepository;
    }

    @Override
    public List<Pays> findAll() {
        return paysRepository.findAll();
    }

    @Override
    public Pays findById(long id) throws ResourceNotFoundException {
        Optional<Pays> pays = paysRepository.findById(id);
        if (pays.isPresent()) {
            return pays.get();
        } else {
            throw new ResourceNotFoundException("Pays non disponible avec l'id : " + id);
        }
    }

    @Override
    public Pays create(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public Pays update(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public void delete(Pays pays) {
        paysRepository.delete(pays);
    }

    @Override
    public void delete(long id) {
        paysRepository.deleteById(id);
    }
}

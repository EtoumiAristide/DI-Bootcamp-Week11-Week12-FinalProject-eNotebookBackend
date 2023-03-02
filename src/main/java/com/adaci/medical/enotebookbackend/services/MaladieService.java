package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Maladie;
import com.adaci.medical.enotebookbackend.repositories.MaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaladieService implements ApiContract<Maladie> {
    private final MaladieRepository maladieRepository;

    @Autowired
    public MaladieService(MaladieRepository maladieRepository) {
        this.maladieRepository = maladieRepository;
    }

    @Override
    public List<Maladie> findAll() {
        return maladieRepository.findAll();
    }

    @Override
    public Maladie findById(long id) throws ResourceNotFoundException {
        Optional<Maladie> maladie = maladieRepository.findById(id);
        if (maladie.isPresent()) {
            return maladie.get();
        } else {
            throw new ResourceNotFoundException("Maladie non disponible avec l'id : " + id);
        }
    }

    @Override
    public Maladie create(Maladie maladie) {
        return maladieRepository.save(maladie);
    }

    @Override
    public Maladie update(Maladie maladie) {
        return maladieRepository.save(maladie);
    }

    @Override
    public void delete(Maladie maladie) {
        maladieRepository.delete(maladie);
    }

    @Override
    public void delete(long id) {
        maladieRepository.deleteById(id);
    }
}

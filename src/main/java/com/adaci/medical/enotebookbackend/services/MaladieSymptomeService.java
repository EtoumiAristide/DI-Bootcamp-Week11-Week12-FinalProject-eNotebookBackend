package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.MaladieSymptome;
import com.adaci.medical.enotebookbackend.repositories.MaladieSymptomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaladieSymptomeService implements ApiContract<MaladieSymptome> {

    private final MaladieSymptomeRepository maladieSymptomeRepository;

    @Autowired
    public MaladieSymptomeService(MaladieSymptomeRepository maladieSymptomeRepository) {
        this.maladieSymptomeRepository = maladieSymptomeRepository;
    }

    @Override
    public List<MaladieSymptome> findAll() {
        return maladieSymptomeRepository.findAll();
    }

    @Override
    public MaladieSymptome findById(long id) throws ResourceNotFoundException {
        Optional<MaladieSymptome> maladieSymptome = maladieSymptomeRepository.findById(id);
        if (maladieSymptome.isPresent()) {
            return maladieSymptome.get();
        } else {
            throw new ResourceNotFoundException("Maladie symptome non disponible avec l'id : " + id);
        }
    }

    @Override
    public MaladieSymptome create(MaladieSymptome maladieSymptome) {
        return maladieSymptomeRepository.save(maladieSymptome);
    }

    @Override
    public MaladieSymptome update(MaladieSymptome maladieSymptome) {
        return maladieSymptomeRepository.save(maladieSymptome);
    }

    @Override
    public void delete(MaladieSymptome maladieSymptome) {
        maladieSymptomeRepository.delete(maladieSymptome);
    }

    @Override
    public void delete(long id) {
        maladieSymptomeRepository.deleteById(id);
    }
}

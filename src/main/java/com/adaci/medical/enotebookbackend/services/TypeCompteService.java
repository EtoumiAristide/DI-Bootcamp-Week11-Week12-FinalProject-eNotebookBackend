package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.TypeCompte;
import com.adaci.medical.enotebookbackend.repositories.TypeCompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCompteService implements ApiContract<TypeCompte> {

    private final TypeCompteRepository typeCompteRepository;

    @Autowired
    public TypeCompteService(TypeCompteRepository typeCompteRepository) {
        this.typeCompteRepository = typeCompteRepository;
    }

    @Override
    public List<TypeCompte> findAll() {
        return typeCompteRepository.findAll();
    }

    @Override
    public TypeCompte findById(long id) throws ResourceNotFoundException {
        Optional<TypeCompte> typeCompte = typeCompteRepository.findById(id);
        if (typeCompte.isPresent()) {
            return typeCompte.get();
        } else {
            throw new ResourceNotFoundException("Type Compte non disponible avec l'id : " + id);
        }
    }

    @Override
    public TypeCompte create(TypeCompte typeCompte) {
        return typeCompteRepository.save(typeCompte);
    }

    @Override
    public TypeCompte update(TypeCompte typeCompte) {
        return typeCompteRepository.save(typeCompte);
    }

    @Override
    public void delete(TypeCompte typeCompte) {
        typeCompteRepository.delete(typeCompte);
    }

    @Override
    public void delete(long id) {
        typeCompteRepository.deleteById(id);
    }
}

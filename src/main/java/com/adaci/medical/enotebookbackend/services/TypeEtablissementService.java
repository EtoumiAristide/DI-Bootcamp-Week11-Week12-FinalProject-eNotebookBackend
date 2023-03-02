package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.TypeEtablissement;
import com.adaci.medical.enotebookbackend.repositories.TypeEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeEtablissementService implements ApiContract<TypeEtablissement> {

    private final TypeEtablissementRepository typeEtablissementRepository;

    @Autowired
    public TypeEtablissementService(TypeEtablissementRepository typeEtablissementRepository) {
        this.typeEtablissementRepository = typeEtablissementRepository;
    }

    @Override
    public List<TypeEtablissement> findAll() {
        return typeEtablissementRepository.findAll();
    }

    @Override
    public TypeEtablissement findById(long id) throws ResourceNotFoundException {
        Optional<TypeEtablissement> typeEtablissement = typeEtablissementRepository.findById(id);
        if (typeEtablissement.isPresent()) {
            return typeEtablissement.get();
        } else {
            throw new ResourceNotFoundException("Type Etablissement non disponible avec l'id : " + id);
        }
    }

    @Override
    public TypeEtablissement create(TypeEtablissement typeEtablissement) {
        return typeEtablissementRepository.save(typeEtablissement);
    }

    @Override
    public TypeEtablissement update(TypeEtablissement typeEtablissement) {
        return typeEtablissementRepository.save(typeEtablissement);
    }

    @Override
    public void delete(TypeEtablissement typeEtablissement) {
        typeEtablissementRepository.delete(typeEtablissement);
    }

    @Override
    public void delete(long id) {
        typeEtablissementRepository.deleteById(id);
    }
}

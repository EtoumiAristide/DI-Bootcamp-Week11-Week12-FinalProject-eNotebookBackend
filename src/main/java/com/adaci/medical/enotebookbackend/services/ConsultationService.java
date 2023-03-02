package com.adaci.medical.enotebookbackend.services;

import com.adaci.medical.enotebookbackend.exceptions.ResourceNotFoundException;
import com.adaci.medical.enotebookbackend.models.Consultation;
import com.adaci.medical.enotebookbackend.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService implements ApiContract<Consultation> {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation findById(long id) throws ResourceNotFoundException {
        Optional<Consultation> consultation = consultationRepository.findById(id);
        if (consultation.isPresent()) {
            return consultation.get();
        } else {
            throw new ResourceNotFoundException("Consultation non disponible avec l'id : " + id);
        }
    }

    @Override
    public Consultation create(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation update(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public void delete(Consultation consultation) {
        consultationRepository.delete(consultation);
    }

    @Override
    public void delete(long id) {
        consultationRepository.deleteById(id);
    }
}

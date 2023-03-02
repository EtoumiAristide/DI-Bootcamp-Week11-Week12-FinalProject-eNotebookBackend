package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class ConsultationKey implements Serializable {
    @Column(name = "patient_id")
    private long patienId;

    @Column(name = "medecin_id")
    private long medecinId;
}

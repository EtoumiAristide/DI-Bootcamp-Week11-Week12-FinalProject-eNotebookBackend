package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ConsultationKey implements Serializable {
    @Column(name = "patient_id")
    private long patienId;

    @Column(name = "medecin_id")
    private long medecinId;
}

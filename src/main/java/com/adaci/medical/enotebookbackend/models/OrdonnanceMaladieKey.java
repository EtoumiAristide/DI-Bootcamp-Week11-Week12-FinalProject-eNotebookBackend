package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class OrdonnanceMaladieKey implements Serializable {
    @Column(name = "ordonnance_id")
    private long ordonnanceId;

    @Column(name = "maladie_id")
    private long maladieId;
}

package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class AdresseKey implements Serializable {
    @Column(name = "personne_id")
    private long personneId;

    @Column(name = "commune_id")
    private long communeId;
}

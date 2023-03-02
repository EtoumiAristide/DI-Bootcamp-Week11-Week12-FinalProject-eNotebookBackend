package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class SpecialiteEtablissementKey implements Serializable {

    @Column(name = "specialite_id")
    private long specialiteId;

    @Column(name = "etablissement_id")
    private long etablissementId;
}

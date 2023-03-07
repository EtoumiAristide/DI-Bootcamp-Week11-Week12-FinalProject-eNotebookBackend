package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialiteEtablissementKey implements Serializable {

    @Column(name = "specialite_id")
    private long specialiteId;

    @Column(name = "etablissement_id")
    private long etablissementId;
}

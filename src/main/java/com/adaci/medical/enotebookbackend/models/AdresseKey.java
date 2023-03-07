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
public class AdresseKey implements Serializable {
    @Column(name = "personne_id")
    private long personneId;

    @Column(name = "commune_id")
    private long communeId;
}

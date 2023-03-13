package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Adresse implements Serializable {
    @EmbeddedId
    private AdresseKey Id;

    @Nullable
    private String quartier;

    @Nullable
    private String rue;

    @Column(name = "boite_postale")
    @Nullable
    private String boitePostale;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @MapsId("personneId")
    @JoinColumn(name = "personne_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private Personne personne;

    @ManyToOne
    @MapsId("communeId")
    @JoinColumn(name = "commune_id")
    @JsonIdentityReference(alwaysAsId = false)
    private Commune commune;
}

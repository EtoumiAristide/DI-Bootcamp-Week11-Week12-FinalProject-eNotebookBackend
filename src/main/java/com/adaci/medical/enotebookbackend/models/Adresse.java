package com.adaci.medical.enotebookbackend.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @MapsId("personneId")
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @MapsId("communeId")
    @JoinColumn(name = "commune_id")
    private Commune commune;
}

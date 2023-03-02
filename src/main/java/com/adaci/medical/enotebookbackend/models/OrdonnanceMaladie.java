package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordonnance_maladie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrdonnanceMaladie implements Serializable {
    @EmbeddedId
    private OrdonnanceMaladieKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @MapsId("ordonnanceId")
    @JoinColumn(name = "ordonnance_id")
    private Ordonnance ordonnance;

    @ManyToOne
    @MapsId("maladieId")
    @JoinColumn(name = "maladie_id")
    private Maladie maladie;

    @OneToMany(mappedBy = "ordonnanceMaladie")
    private List<Traitement> traitementList;
}

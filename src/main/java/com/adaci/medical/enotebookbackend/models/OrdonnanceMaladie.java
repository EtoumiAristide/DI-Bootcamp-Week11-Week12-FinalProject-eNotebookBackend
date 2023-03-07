package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrdonnanceMaladie implements Serializable {
    @EmbeddedId
    private OrdonnanceMaladieKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @MapsId("ordonnanceId")
    @JoinColumn(name = "ordonnance_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Ordonnance ordonnance;

    @ManyToOne
    @MapsId("maladieId")
    @JoinColumn(name = "maladie_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Maladie maladie;

    @OneToMany(mappedBy = "ordonnanceMaladie")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Traitement> traitementList;
}

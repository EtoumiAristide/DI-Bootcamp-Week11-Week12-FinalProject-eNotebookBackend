package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "specialite_etablissement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties("createdAt, updatedAt")
public class SpecialiteEtablissement implements Serializable {

    @EmbeddedId
    private SpecialiteEtablissementKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @MapsId("specialiteId")
    @JoinColumn(name = "specialite_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Specialite specialite;

    @ManyToOne
    @MapsId("etablissementId")
    @JoinColumn(name = "etablissement_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Etablissement etablissement;

    @OneToMany(mappedBy = "specialiteEtablissement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Medecin> medecinList;

}

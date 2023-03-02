package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SpecialiteEtablissement implements Serializable {

    @EmbeddedId
    private SpecialiteEtablissementKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @MapsId("specialiteId")
    @JoinColumn(name = "specialite_id")
    private Specialite specialite;

    @ManyToOne
    @MapsId("etablissementId")
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;

    @OneToMany(mappedBy = "specialiteEtablissement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medecin> medecinList;

}

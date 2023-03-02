package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Medecin extends Physique implements Serializable {
    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String matricule;

    @Column(name = "date_prise_service")
    @NotNull
    @NotBlank
    private Date datePriseService;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Medecin(String tel1, String tel2, String tel3, String email, String nom, String prenoms, Timestamp dateNaissance, String lieuNaissance, String nomPrenomPere, String nomPrenomMere, String matricule, Date datePriseService) {
        super(tel1, tel2, tel3, email, nom, prenoms, dateNaissance, lieuNaissance, nomPrenomPere, nomPrenomMere);
        this.matricule = matricule;
        this.datePriseService = datePriseService;
    }

    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultation> consultationList;

    @ManyToOne
    private SpecialiteEtablissement specialiteEtablissement;
}

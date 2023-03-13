package com.adaci.medical.enotebookbackend.models;

import com.adaci.medical.enotebookbackend.enums.PersonnelMedicalType;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Medecin extends Physique implements Serializable {
    @NotNull(message = "Le matricule du medeci est obligatoire")
    @NotBlank(message = "Le matricule du medecin ne peut être vide")
    @Column(columnDefinition = "VARCHAR(50)")
    private String matricule;

    @Column(name = "date_prise_service")
    @NotNull(message = "La date de prise de service du medecin est obligatoire")
    @NotBlank(message = "La date de prise de service du medecin ne peut être vide")
    private Date datePriseService;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonIgnore
    private Date updatedAt;

    @Column(name = "personel_medical_type", columnDefinition = "VARCHAR")
    @Enumerated(EnumType.STRING)
    private PersonnelMedicalType personnelMedicalType;

    public Medecin(String tel1, String tel2, String tel3, String email, String nom, String prenoms, Date dateNaissance, String lieuNaissance, String nomPrenomPere, String nomPrenomMere, String nomPersonneUrgence, String contactPersonneUrgence, String matricule, Date datePriseService) {
        super(tel1, tel2, tel3, email, nom, prenoms, dateNaissance, lieuNaissance, nomPrenomPere, nomPrenomMere, nomPersonneUrgence, contactPersonneUrgence);
        this.matricule = matricule;
        this.datePriseService = datePriseService;
    }

    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Consultation> consultationList;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private SpecialiteEtablissement specialiteEtablissement;
}

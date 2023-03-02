package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Patient extends Physique implements Serializable {

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Patient(String tel1, String tel2, String tel3, String email, String nom, String prenoms, Date dateNaissance, String lieuNaissance, String nomPrenomPere, String nomPrenomMere, String nomPersonneUrgence, String contactPersonneUrgence) {
        super(tel1, tel2, tel3, email, nom, prenoms, dateNaissance, lieuNaissance, nomPrenomPere, nomPrenomMere, nomPersonneUrgence, contactPersonneUrgence);
    }

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultation> consultationList;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AntecedentMedical> antecedentMedicalList;
}

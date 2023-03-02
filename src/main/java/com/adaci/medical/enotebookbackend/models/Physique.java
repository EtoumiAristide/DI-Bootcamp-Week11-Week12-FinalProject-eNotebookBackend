package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Physique extends Personne implements Serializable {
    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    @NotBlank
    private String nom;
    @Column(columnDefinition = "VARCHAR(150)")
    @NotNull
    @NotBlank
    private String prenoms;

    @Column(name = "date_naissance", columnDefinition = "DATE")
    @NotNull
    @NotBlank
    private Timestamp dateNaissance;

    @Column(name = "lieu_naissance", columnDefinition = "VARCHAR")
    @NotNull
    @NotBlank
    private String lieuNaissance;
    @Basic
    @Column(name = "nom_prenom_pere")
    private String nomPrenomPere;
    @Basic
    @Column(name = "nom_prenom_mere")
    private String nomPrenomMere;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Physique(String tel1, String tel2, String tel3, String email, String nom, String prenoms, Timestamp dateNaissance, String lieuNaissance, String nomPrenomPere, String nomPrenomMere) {
        super(tel1, tel2, tel3, email);
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nomPrenomPere = nomPrenomPere;
        this.nomPrenomMere = nomPrenomMere;
    }
}

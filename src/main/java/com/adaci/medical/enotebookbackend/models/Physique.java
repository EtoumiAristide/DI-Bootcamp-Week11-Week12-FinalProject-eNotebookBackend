package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Physique extends Personne implements Serializable {
    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull(message = "Le nom de la personne est obligatoire")
    @NotBlank(message = "Le nom de la personne ne peut être vide")
    private String nom;
    @Column(columnDefinition = "VARCHAR(150)")
    @NotNull(message = "Le(s) prénom(s) de la personne est obligatoire")
    @NotBlank(message = "Le(s) prénom(s) de la personne ne peut être vide")
    private String prenoms;

    @Column(name = "date_naissance", columnDefinition = "DATE")
    //@NotNull(message = "La date de naissance la personne est obligatoire")
    //@NotBlank(message = "La date de naissance la personne ne peut être vide")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "lieu_naissance", columnDefinition = "VARCHAR")
    //@NotNull(message = "Le lieu de naissance de la personne est obligatoire")
    //@NotBlank(message = "La lieu de naissance de la personne ne peut être vide")
    private String lieuNaissance;

    @Column(name = "nom_prenom_pere")
    private String nomPrenomPere;

    @Column(name = "nom_prenom_mere")
    private String nomPrenomMere;

    @Column(name = "nom_personne_urgence")
    //@NotNull(message = "La personne à contacter en cas d'urgence est obligatoire")
    //@NotBlank(message = "La personne à contacter en cas d'urgence ne peut être vide")
    private String nomPersonneUrgence;

    @Column(name = "contact_personne_urgence")
    //@NotNull(message = "Le numero de la personne à contacter en cas d'urgence est obligatoire")
    //@NotBlank(message = "Le numero de la personne à contacter en cas d'urgence ne peut être vide")
    private String contactPersonneUrgence;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    public Physique(String tel1, String tel2, String tel3, String email, String nom, String prenoms, Date dateNaissance, String lieuNaissance, String nomPrenomPere, String nomPrenomMere, String nomPersonneUrgence, String contactPersonneUrgence) {
        super(tel1, tel2, tel3, email);
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nomPrenomPere = nomPrenomPere;
        this.nomPrenomMere = nomPrenomMere;
        this.nomPersonneUrgence = nomPersonneUrgence;
        this.contactPersonneUrgence = contactPersonneUrgence;
    }
}

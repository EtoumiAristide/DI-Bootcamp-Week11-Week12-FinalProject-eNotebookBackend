package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compte_utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompteUtilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Le login est obligatoire")
    @NotBlank(message = "Le login ne peut être vide")
    private String login;

    @NotNull(message = "le mot de passe est obligatoire")
    @NotBlank(message = "Le mot de passe ne peut être vide")
    private String password;

    //@NotNull(message = "La phrase de recupération 1 est obligatoire")
    //@NotBlank(message = "La phrase de recupération 1 ne peut être vide")
    @Column(name = "phrase_recup1")
    private String phraseRecup1;

    //@NotNull(message = "La reponse de recupération 1 est obligatoire")
    //@NotBlank(message = "La reponse de recupération 1 ne peut être vide")
    @Column(name = "reponse_recup1")
    private String reponseRecup1;

    @Column(name = "phrase_recup2")
    private String phraseRecup2;

    @Column(name = "reponse_recup2")
    private String reponseRecup2;

    @Column(name = "phrase_recup3")
    private String phraseRecup3;

    @Column(name = "reponse_recup3")
    private String reponseRecup3;

    @Column(name = "authentification_double_facteur")
    private boolean authentificationDoubleFacteur;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = false)
    private TypeCompte typeCompte;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = false)
    private Personne personne;

    @OneToMany(mappedBy = "compteUtilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private List<SessionUtilisateur> sessionUtilisateurList;
}

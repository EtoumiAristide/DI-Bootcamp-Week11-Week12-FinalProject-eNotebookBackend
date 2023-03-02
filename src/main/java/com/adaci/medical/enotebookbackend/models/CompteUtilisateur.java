package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "compte_utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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

    @NotNull(message = "La phrase de recupération 1 est obligatoire")
    @NotBlank(message = "La phrase de recupération 1 ne peut être vide")
    @Column(name = "phrase_recup1")
    private String phraseRecup1;

    @NotNull(message = "La reponse de recupération 1 est obligatoire")
    @NotBlank(message = "La reponse de recupération 1 ne peut être vide")
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

    @ManyToOne
    private TypeCompte typeCompte;

    @ManyToOne
    private Personne personne;

    @OneToMany(mappedBy = "compteUtilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SessionUtilisateur> sessionUtilisateurList;
}

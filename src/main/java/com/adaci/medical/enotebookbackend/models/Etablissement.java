package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Etablissement extends Personne implements Serializable {

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Le nom de l'établissement est obligatoire")
    @NotBlank(message = "Le nom de l'établissement ne peut être vide")
    private String nom;

    @Column(name = "autorisation_activite", columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Le numero d'autorisation est obligatoire")
    @NotBlank(message = "Le numero d'autorisation ne peut être vide")
    private String autorisationActivite;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    public Etablissement(String tel1, String tel2, String tel3, String email, String nom) {
        super(tel1, tel2, tel3, email);
        this.nom = nom;
    }

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private TypeEtablissement typeEtablissement;

    @OneToMany(mappedBy = "etablissement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<SpecialiteEtablissement> specialiteEtablissementList;
}

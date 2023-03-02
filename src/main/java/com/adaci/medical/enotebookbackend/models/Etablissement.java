package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Etablissement extends Personne implements Serializable {

    @Basic
    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    @NotBlank
    private String nom;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Etablissement(String tel1, String tel2, String tel3, String email, String nom) {
        super(tel1, tel2, tel3, email);
        this.nom = nom;
    }

    @ManyToOne
    private TypeEtablissement typeEtablissement;

    @OneToMany(mappedBy = "etablissement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecialiteEtablissement> specialiteEtablissementList;
}

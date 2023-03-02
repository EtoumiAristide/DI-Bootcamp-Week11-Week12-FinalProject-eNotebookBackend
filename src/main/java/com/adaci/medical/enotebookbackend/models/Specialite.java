package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Specialite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    @NotBlank
    private String libelle;

    @OneToMany(mappedBy = "specialite", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Maladie> maladieList;

    @OneToMany(mappedBy = "specialite", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecialiteEtablissement> specialiteEtablissementList;

}

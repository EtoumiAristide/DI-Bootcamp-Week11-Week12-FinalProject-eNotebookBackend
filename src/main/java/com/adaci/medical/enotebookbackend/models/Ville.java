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
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Ville implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long Id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull(message = "Le nom de la ville est obligatoire")
    @NotBlank(message = "Le nom de la ville ne peut être vide")
    private String nom;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    private Pays pays;

    @OneToMany(mappedBy = "ville")
    private List<Commune> communeList;
}

package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Traitement implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(columnDefinition = "VARCHAR(150)")
    @NotNull(message = "Le libéllé du traitement est obligatoire")
    @NotBlank(message = "La libéllé du traitement ne peut être vide")
    private String libelle;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    private OrdonnanceMaladie ordonnanceMaladie;

}

package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
@EqualsAndHashCode
public class Consultation implements Serializable {

    @EmbeddedId
    private ConsultationKey Id;

    @NotNull
    @NotBlank
    private Date date;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull(message = "Le libéllé de la consultation est obligatoire")
    @NotEmpty(message = "La libéllé de la consultation ne peut être vide")
    private String libelle;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @MapsId("medecinId")
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<Ordonnance> ordonnanceList;
}

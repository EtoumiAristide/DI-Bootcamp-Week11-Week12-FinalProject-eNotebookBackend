package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
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

    @Column(columnDefinition = "VARCHAR(150) NOT NULL")
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

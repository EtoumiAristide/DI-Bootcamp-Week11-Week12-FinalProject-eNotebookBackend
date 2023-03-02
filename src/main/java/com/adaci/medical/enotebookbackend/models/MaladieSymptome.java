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
public class MaladieSymptome implements Serializable {
    @EmbeddedId
    private MaladieSymtomeKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @MapsId("maladieId")
    @JoinColumn(name = "maladie_id")
    private Maladie maladie;

    @ManyToOne
    @MapsId("symptomeId")
    @JoinColumn(name = "symptome_id")
    private Symptome symptome;
}

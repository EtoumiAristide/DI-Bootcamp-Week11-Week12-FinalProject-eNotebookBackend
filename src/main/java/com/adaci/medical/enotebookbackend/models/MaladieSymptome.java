package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "maladie_symptome")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MaladieSymptome implements Serializable {
    @EmbeddedId
    private MaladieSymtomeKey Id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @MapsId("maladieId")
    @JoinColumn(name = "maladie_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Maladie maladie;

    @ManyToOne
    @MapsId("symptomeId")
    @JoinColumn(name = "symptome_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Symptome symptome;
}

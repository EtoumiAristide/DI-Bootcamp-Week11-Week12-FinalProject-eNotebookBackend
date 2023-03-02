package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Ville implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long Id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String libelle;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @ManyToOne
    private Pays pays;

    @OneToMany(mappedBy = "ville")
    private List<Commune> communeList;
}

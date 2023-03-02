package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class MaladieSymtomeKey implements Serializable {

    @Column(name = "maladie_id")
    private long maladieId;

    @Column(name = "symptome_id")
    private long symptomeId;
}

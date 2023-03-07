package com.adaci.medical.enotebookbackend.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaladieSymtomeKey implements Serializable {

    @Column(name = "maladie_id")
    private long maladieId;

    @Column(name = "symptome_id")
    private long symptomeId;
}

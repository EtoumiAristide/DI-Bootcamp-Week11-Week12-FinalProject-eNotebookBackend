package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "session", columnDefinition = "VARCHAR")
    private SessionType sessionType;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private CompteUtilisateur compteUtilisateur;

    public SessionUtilisateur(SessionType sessionType) {
        this.sessionType = sessionType;
    }
}

package com.adaci.medical.enotebookbackend.models;

import com.adaci.medical.enotebookbackend.enums.SessionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "session_utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

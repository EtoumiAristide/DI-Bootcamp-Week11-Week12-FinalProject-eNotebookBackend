package com.adaci.medical.enotebookbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(name = "tel1", columnDefinition = "CHAR(15)")
    @NotNull(message = "Le numero de téléphone 1 est obligatoire")
    @NotBlank(message = "Le numero de téléphone 1 ne peut être vide")
    private String tel1;

    @Column(name = "tel2", nullable = true, length = 15)
    private String tel2;

    @Column(name = "tel3", nullable = true, length = 15)
    private String tel3;

    @Email(message = "L'adresse email est incorrecte")
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "personne", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adresse> adresseList;

    @OneToMany(mappedBy = "personne", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CompteUtilisateur> compteUtilisateurList;

    public Personne(String tel1, String tel2, String tel3, String email) {
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
        this.email = email;
    }
}

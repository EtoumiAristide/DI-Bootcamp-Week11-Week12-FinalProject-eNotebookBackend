package com.adaci.medical.enotebookbackend.payloads;

import com.adaci.medical.enotebookbackend.models.TypeCompte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDataPayload implements Serializable {
    @NotNull(message = "Le nom est obligatoire")
    private String nom;
    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;
    @NotNull(message = "Le numero de télephone est obligatoire")
    private String tel;
    @NotNull(message = "Le login est obligatoire")
    @NotBlank(message = "Le login ne doit pas être vide")
    private String login;
    @NotNull(message = "Le mot de passe est obligatoire")
    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    private String password;
    private String passwordConfirmation;

    private TypeCompte typeCompte;
}

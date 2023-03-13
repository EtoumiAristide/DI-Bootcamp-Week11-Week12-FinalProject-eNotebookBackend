package com.adaci.medical.enotebookbackend.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDataPayload implements Serializable {
    @NotNull(message = "Le login est obligatoire")
    @NotBlank(message = "Le login ne doit pas être vide")
    private String login;
    @NotNull(message = "Le mot de passe est obligatoire")
    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    private String password;
}

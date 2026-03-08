package com.luisu404.challenge_forohub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,

        @Email
        String correoElectronico,

        @NotBlank
        String nombreUsuario,

        @NotBlank
        String contrasena
) {
}

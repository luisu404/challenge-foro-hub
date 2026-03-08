package com.luisu404.challenge_forohub.domain.usuario.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        String nombre,
        String correoElectronico,
        String nombreUsuario,
        String contrasena
) {

}

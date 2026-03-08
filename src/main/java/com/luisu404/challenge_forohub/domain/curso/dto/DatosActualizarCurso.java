package com.luisu404.challenge_forohub.domain.curso.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
        @NotNull Long id,
        String nombre,
        String categoria
) {

}

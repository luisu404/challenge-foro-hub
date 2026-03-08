package com.luisu404.challenge_forohub.domain.respuesta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearRespuestaTopico(
        @NotBlank
        String mensaje,

        @NotNull
        Long topicoId,

        @NotNull
        Long usuarioId
) {
}

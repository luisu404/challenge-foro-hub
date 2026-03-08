package com.luisu404.challenge_forohub.domain.respuesta.dto;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull String mensaje,
        @NotNull Long idTopico,
        @NotNull Long idUsuario
) {
}

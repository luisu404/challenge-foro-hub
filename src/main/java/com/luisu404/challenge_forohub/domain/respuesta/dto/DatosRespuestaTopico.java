package com.luisu404.challenge_forohub.domain.respuesta.dto;

import com.luisu404.challenge_forohub.domain.topico.StatusTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status
) {
}

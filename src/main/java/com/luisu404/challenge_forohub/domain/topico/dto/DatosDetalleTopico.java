package com.luisu404.challenge_forohub.domain.topico.dto;

import com.luisu404.challenge_forohub.domain.topico.StatusTopico;
import com.luisu404.challenge_forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        Long idUsuario,
        Long idCurso


) {

    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }

}

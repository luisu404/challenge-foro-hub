package com.luisu404.challenge_forohub.domain.curso.dto;

import com.luisu404.challenge_forohub.domain.curso.Categoria;
import com.luisu404.challenge_forohub.domain.topico.StatusTopico;

import java.time.LocalDateTime;

public record DatosRegistroCurso(
        Long id,
        String nombre,
        Categoria categoria
) {
}

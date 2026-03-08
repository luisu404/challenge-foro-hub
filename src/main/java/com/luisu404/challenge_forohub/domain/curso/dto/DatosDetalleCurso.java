package com.luisu404.challenge_forohub.domain.curso.dto;

import com.luisu404.challenge_forohub.domain.curso.Curso;

public record DatosDetalleCurso(
        String nombre,
        String categoria
) {

public DatosDetalleCurso(Curso curso){
        this(
                curso.getNombre(),
                curso.getCategoria().name()
        );
    }
}

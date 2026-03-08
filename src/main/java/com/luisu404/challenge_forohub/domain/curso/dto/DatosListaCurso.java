package com.luisu404.challenge_forohub.domain.curso.dto;

import com.luisu404.challenge_forohub.domain.curso.Curso;

public record DatosListaCurso(
        Long id,
        String nombre,
        String categoria
) {
    public DatosListaCurso(Curso curso){
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria().name()
        );
    }
}

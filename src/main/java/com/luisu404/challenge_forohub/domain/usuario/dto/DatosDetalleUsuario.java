package com.luisu404.challenge_forohub.domain.usuario.dto;

import com.luisu404.challenge_forohub.domain.usuario.Usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String nombreUsuario,
        Boolean activo
) {
    public DatosDetalleUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getNombreUsuario(),
                usuario.getActivo()
        );
    }
}

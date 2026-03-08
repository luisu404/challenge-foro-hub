package com.luisu404.challenge_forohub.domain.usuario.dto;

import com.luisu404.challenge_forohub.domain.usuario.Usuario;

public record DatosListaUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String nombreUsuario
) {
    public DatosListaUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getNombreUsuario()
        );
    }


}

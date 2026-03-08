package com.luisu404.challenge_forohub.domain.topico.dto;

import com.luisu404.challenge_forohub.domain.topico.StatusTopico;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosActualizarUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        StatusTopico status
) {

}

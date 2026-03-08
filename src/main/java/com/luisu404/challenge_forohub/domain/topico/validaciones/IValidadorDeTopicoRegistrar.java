package com.luisu404.challenge_forohub.domain.topico.validaciones;

import com.luisu404.challenge_forohub.domain.topico.dto.DatosActualizarTopico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosRegistroTopico;

public interface IValidadorDeTopicoRegistrar {
    void validar(DatosRegistroTopico datos);
}

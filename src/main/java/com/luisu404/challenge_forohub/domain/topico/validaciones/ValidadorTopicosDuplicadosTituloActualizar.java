package com.luisu404.challenge_forohub.domain.topico.validaciones;

import com.luisu404.challenge_forohub.domain.topico.dto.DatosActualizarTopico;
import com.luisu404.challenge_forohub.infrastructure.exceptions.ValidacionException;
import com.luisu404.challenge_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicosDuplicadosTituloActualizar implements IValidadorDeTopicoActualizar {

    @Autowired private TopicoRepository topicoRepository;
    @Override
    public void validar(DatosActualizarTopico datos) {
        var topicoExisteNombre = topicoRepository.existsByTituloIgnoreCase(datos.titulo());
        if (topicoExisteNombre){
            throw new ValidacionException("El titulo de este topico existe en la base de datos");
        }
    }
}

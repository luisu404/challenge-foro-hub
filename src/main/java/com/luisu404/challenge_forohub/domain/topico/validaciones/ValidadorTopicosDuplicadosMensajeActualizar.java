package com.luisu404.challenge_forohub.domain.topico.validaciones;

import com.luisu404.challenge_forohub.domain.topico.dto.DatosActualizarTopico;
import com.luisu404.challenge_forohub.infrastructure.exceptions.ValidacionException;
import com.luisu404.challenge_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicosDuplicadosMensajeActualizar implements IValidadorDeTopicoActualizar{

    @Autowired
    private TopicoRepository topicoRepository;
    @Override
    public void validar(DatosActualizarTopico datos) {
        var topicoExisteMensaje = topicoRepository.existsByMensajeIgnoreCase(datos.mensaje());
        if (topicoExisteMensaje){
            throw new ValidacionException("El mensaje de este tópico existe en la base de datos");
        }
    }


}
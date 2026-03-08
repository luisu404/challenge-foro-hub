package com.luisu404.challenge_forohub.service;


import com.luisu404.challenge_forohub.domain.respuesta.Respuesta;
import com.luisu404.challenge_forohub.domain.respuesta.dto.DatosCrearRespuestaTopico;
import com.luisu404.challenge_forohub.repository.RespuestaRepository;
import com.luisu404.challenge_forohub.repository.TopicoRepository;
import com.luisu404.challenge_forohub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public RespuestaService(RespuestaRepository respuestaRepository,
                            TopicoRepository topicoRepository,
                            UsuarioRepository usuarioRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Respuesta crearRespuesta(DatosCrearRespuestaTopico datos){

        var usuario = usuarioRepository.findById(datos.usuarioId()).orElseThrow();
        var topico = topicoRepository.findById(datos.topicoId()).orElseThrow();

        Respuesta respuesta = new Respuesta(
                null,
                datos.mensaje(),
                LocalDateTime.now(),
                false,
                topico,
                usuario
        );

        return respuestaRepository.save(respuesta);
    }

}

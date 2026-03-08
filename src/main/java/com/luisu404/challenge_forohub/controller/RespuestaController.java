package com.luisu404.challenge_forohub.controller;

import com.luisu404.challenge_forohub.domain.respuesta.Respuesta;
import com.luisu404.challenge_forohub.domain.respuesta.dto.DatosAgregarRespuestaTopico;
import com.luisu404.challenge_forohub.domain.respuesta.dto.DatosRegistroRespuesta;
import com.luisu404.challenge_forohub.repository.RespuestaRepository;
import com.luisu404.challenge_forohub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired private RespuestaRepository  respuestaRepository;


    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuesta respuestaDTO, UriComponentsBuilder uriComponentsBuilder){
        var respuesta = new Respuesta(respuestaDTO);
        respuestaRepository.save(respuesta);
        var uri = uriComponentsBuilder.path("api/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleRespuesta(respuesta));
    }
}

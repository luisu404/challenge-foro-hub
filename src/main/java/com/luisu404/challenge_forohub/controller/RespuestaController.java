package com.luisu404.challenge_forohub.controller;

import com.luisu404.challenge_forohub.domain.respuesta.dto.DatosCrearRespuestaTopico;
import com.luisu404.challenge_forohub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService service;

    public RespuestaController(RespuestaService service) {
        this.service = service;
    }

    @PostMapping
    public Object crear(@RequestBody @Valid DatosCrearRespuestaTopico datos){
        return service.crearRespuesta(datos);
    }

}

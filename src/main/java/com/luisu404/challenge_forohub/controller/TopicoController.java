package com.luisu404.challenge_forohub.controller;

import com.luisu404.challenge_forohub.domain.topico.dto.DatosActualizarTopico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosDetalleTopico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosListaTopico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosRegistroTopico;
import com.luisu404.challenge_forohub.domain.topico.validaciones.IValidadorDeTopicoActualizar;
import com.luisu404.challenge_forohub.domain.topico.validaciones.IValidadorDeTopicoRegistrar;
import com.luisu404.challenge_forohub.repository.TopicoRepository;
import com.luisu404.challenge_forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/topicos")
public class TopicoController {

    private final TopicoService service;
    @Autowired TopicoRepository topicoRepository;
    @Autowired private List<IValidadorDeTopicoActualizar> validadores;


    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosRegistroTopico datos){
        var detalleTopico = service.crearTopico(datos);
        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size = 10, sort= {"fechaCreacion"}) Pageable paginacion){
        var page = topicoRepository.findAll(paginacion)
                .map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){

        var optionalTopico = topicoRepository.findById(id);

        if(optionalTopico.isPresent()){
            return ResponseEntity.ok(new DatosDetalleTopico(optionalTopico.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datos){
        var topico = topicoRepository.getReferenceById(datos.id());
        validadores.forEach(v->v.validar(datos));
        topico.actualizarInformacionesTopico(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        topicoRepository.deleteById(id);
    }
}

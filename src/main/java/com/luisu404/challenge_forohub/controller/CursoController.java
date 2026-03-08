package com.luisu404.challenge_forohub.controller;

import com.luisu404.challenge_forohub.domain.curso.Curso;
import com.luisu404.challenge_forohub.domain.curso.dto.DatosActualizarCurso;
import com.luisu404.challenge_forohub.domain.curso.dto.DatosDetalleCurso;
import com.luisu404.challenge_forohub.domain.curso.dto.DatosListaCurso;
import com.luisu404.challenge_forohub.domain.curso.dto.DatosRegistroCurso;
import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosActualizarUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosDetalleUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosListaUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosRegistroUsuario;
import com.luisu404.challenge_forohub.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosRegistroCurso datos, UriComponentsBuilder uriComponentsBuilder){
        var curso = new Curso(datos);
        cursoRepository.save(curso);
        var uri = uriComponentsBuilder.path("api/usuario/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaCurso>> listar(@PageableDefault(size = 10)Pageable paginacion){
        var page = cursoRepository.findAllByActivoTrue(paginacion)
                .map(DatosListaCurso::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarCurso cursoDTO){
        var curso = cursoRepository.getReferenceById(cursoDTO.id());
        curso.actualizarInformacionesCurso(cursoDTO);
        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var usuario =  cursoRepository.getReferenceById(id);
        usuario.eliminarCurso();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var curso =  cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }
}

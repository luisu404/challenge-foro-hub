package com.luisu404.challenge_forohub.controller;

import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosActualizarUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosDetalleUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosListaUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosRegistroUsuario;
import com.luisu404.challenge_forohub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;


    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(datos, passwordEncoder);
        usuarioRepository.save(usuario);
        var uri = uriComponentsBuilder.path("api/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listar(@PageableDefault(size = 10)Pageable paginacion){
        var page = usuarioRepository.findAllByActivoTrue(paginacion)
                .map(DatosListaUsuario::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarUsuario usuarioDTO){
        var usuario = usuarioRepository.getReferenceById(usuarioDTO.id());
        usuario.actualizarInformacionesUsuario(usuarioDTO);
        return ResponseEntity.ok(new DatosDetalleUsuario(usuario));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var usuario =  usuarioRepository.getReferenceById(id);
        usuario.eliminarUsuario();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var usuario =  usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleUsuario(usuario));
    }
}

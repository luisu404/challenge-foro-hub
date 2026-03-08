package com.luisu404.challenge_forohub.service;

import com.luisu404.challenge_forohub.domain.topico.StatusTopico;
import com.luisu404.challenge_forohub.domain.topico.Topico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosDetalleTopico;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosRegistroTopico;
import com.luisu404.challenge_forohub.domain.topico.validaciones.IValidadorDeTopicoRegistrar;
import com.luisu404.challenge_forohub.infrastructure.exceptions.ValidacionException;
import com.luisu404.challenge_forohub.repository.CursoRepository;
import com.luisu404.challenge_forohub.repository.UsuarioRepository;
import com.luisu404.challenge_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired private List<IValidadorDeTopicoRegistrar> validadores;
    public TopicoService(TopicoRepository topicoRepository,
                         UsuarioRepository usuarioRepository,
                         CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public DatosDetalleTopico crearTopico(DatosRegistroTopico datos){

        var usuario = usuarioRepository.findById(datos.usuarioId()).get();
        var curso = cursoRepository.findById(datos.cursoId()).get();



        if(usuarioRepository.findById(datos.usuarioId()).isEmpty()){
            throw new ValidacionException("No existe un usuario con el id dado");
        }
        if(cursoRepository.findById(datos.cursoId()).isEmpty()){
            throw new ValidacionException("No existe un curso con el id dado");
        }

        validadores.forEach(v->v.validar(datos));



        var topico = new Topico(
                null,
                datos.titulo(),
                datos.mensaje(),
                LocalDateTime.now(),
                StatusTopico.ABIERTO,
                usuario,
                curso,
                null
        );

        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }


//    public DatosDetalleTopico actualizarTopico(DatosActualizarTopico datos){
//
//        var usuario = topicoRepository.findById(datos.id()).get();
//
//
//        if(usuarioRepository.findById(datos.usuarioId()).isEmpty()){
//            throw new ValidacionException("No existe un usuario con el id dado");
//        }
//        if(cursoRepository.findById(datos.cursoId()).isEmpty()){
//            throw new ValidacionException("No existe un curso con el id dado");
//        }
//
//        validadores.forEach(v->v.validar(datos));
//
//        Topico topico = new Topico();
//        topico.actualizarInformacionesTopico(datos);
//
//        return new DatosDetalleTopico(topico);
//    }


}

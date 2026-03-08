package com.luisu404.challenge_forohub.domain.topico;

import com.luisu404.challenge_forohub.domain.respuesta.Respuesta;
import com.luisu404.challenge_forohub.domain.topico.dto.DatosActualizarTopico;
import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import com.luisu404.challenge_forohub.domain.curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico(Long id, String title, String message, LocalDateTime date, StatusTopico status, Usuario usuario, String curso) {
        this.id=getId();
        this.titulo=getTitulo();
        this.mensaje=getMensaje();
        this.fechaCreacion = getFechaCreacion();
        this.status=getStatus();
        this.usuario=getUsuario();
        this.curso=getCurso();
    }
    public void actualizarInformacionesTopico(@Valid DatosActualizarTopico topicoDTO){

        if(topicoDTO.titulo()!=null){
            this.titulo = topicoDTO.titulo();
        }
        if (topicoDTO.mensaje()!=null){
            this.mensaje = topicoDTO.mensaje();
        }
        if(topicoDTO.status()!=null){
            this.status = topicoDTO.status();
        }

    }

}
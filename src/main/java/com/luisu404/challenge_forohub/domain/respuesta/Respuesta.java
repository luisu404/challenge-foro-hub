package com.luisu404.challenge_forohub.domain.respuesta;

import com.luisu404.challenge_forohub.domain.respuesta.dto.DatosRegistroRespuesta;
import com.luisu404.challenge_forohub.domain.topico.Topico;
import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Respuesta(DatosRegistroRespuesta respuestaDTO){
        this.id = null;
        this.mensaje = respuestaDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now();
       // this.usuario.getId() = respuestaDTO.idUsuario();
    }
}
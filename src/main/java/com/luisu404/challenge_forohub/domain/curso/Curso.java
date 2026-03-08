package com.luisu404.challenge_forohub.domain.curso;

import com.luisu404.challenge_forohub.domain.curso.dto.DatosActualizarCurso;
import com.luisu404.challenge_forohub.domain.curso.dto.DatosRegistroCurso;
import com.luisu404.challenge_forohub.domain.topico.Topico;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosActualizarUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private boolean activo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(DatosRegistroCurso cursoDTO){
        this.id = null;
        this.activo = true;
        this.nombre = cursoDTO.nombre();
        this.categoria = cursoDTO.categoria();
    }

    public void actualizarInformacionesCurso(@Valid DatosActualizarCurso cursoDTO){

        if(cursoDTO.nombre()!=null){
            this.nombre = cursoDTO.nombre();
        }
        if (cursoDTO.categoria()!=null){
            this.categoria = Categoria.valueOf(cursoDTO.categoria());
        }

    }
    public void eliminarCurso(){
        this.activo = false;
    }

}


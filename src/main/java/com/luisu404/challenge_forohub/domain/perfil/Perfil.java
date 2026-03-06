package com.luisu404.challenge_forohub.domain.perfil;

import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "perfiles")
    private Set<Usuario> usuarios;
}

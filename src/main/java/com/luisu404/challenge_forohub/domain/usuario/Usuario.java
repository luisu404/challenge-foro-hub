package com.luisu404.challenge_forohub.domain.usuario;


import com.luisu404.challenge_forohub.domain.respuesta.Respuesta;
import com.luisu404.challenge_forohub.domain.topico.Topico;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosActualizarUsuario;
import com.luisu404.challenge_forohub.domain.usuario.dto.DatosRegistroUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;


@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private String nombreUsuario;
    private Boolean activo;

    @OneToMany(mappedBy = "usuario")
    private List<Topico> topicos;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;


    public Usuario(DatosRegistroUsuario usuarioDTO, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.id = null;
        this.activo = true;
        this.nombre = usuarioDTO.nombre();
        this.correoElectronico = usuarioDTO.correoElectronico();
        this.contrasena =  bCryptPasswordEncoder.encode(usuarioDTO.contrasena());
        this.nombreUsuario = usuarioDTO.nombreUsuario();
    }


    public void actualizarInformacionesUsuario(@Valid DatosActualizarUsuario usuarioDTO){

        if(usuarioDTO.nombre()!=null){
            this.nombre = usuarioDTO.nombre();
        }
        if (usuarioDTO.correoElectronico()!=null){
            this.correoElectronico = usuarioDTO.correoElectronico();
        }
        if(usuarioDTO.nombreUsuario()!=null){
            this.nombreUsuario = usuarioDTO.nombreUsuario();
        }
        if(usuarioDTO.contrasena()!=null){
            this.contrasena = usuarioDTO.contrasena();
        }


    }


    public void eliminarUsuario(){
        this.activo = false;
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {return List.of();}
    @Override public String getPassword(){return contrasena;}
    @Override public String getUsername() {return nombreUsuario;}
    @Override public boolean isAccountNonExpired() {return UserDetails.super.isAccountNonExpired();}
    @Override public boolean isAccountNonLocked() {return UserDetails.super.isAccountNonLocked();}
    @Override public boolean isCredentialsNonExpired() {return UserDetails.super.isCredentialsNonExpired();}
    @Override public boolean isEnabled() {return UserDetails.super.isEnabled();}
}

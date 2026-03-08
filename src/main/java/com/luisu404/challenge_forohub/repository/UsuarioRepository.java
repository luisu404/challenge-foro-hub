package com.luisu404.challenge_forohub.repository;

import com.luisu404.challenge_forohub.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Page<Usuario> findAllByActivoTrue(Pageable paginacion);

    UserDetails findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}

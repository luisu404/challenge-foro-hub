package com.luisu404.challenge_forohub.repository;

import com.luisu404.challenge_forohub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByMensajeIgnoreCase(String titulo);
    boolean existsByTituloIgnoreCase(String mensaje);

    @Override
    Page<Topico> findAll(Pageable paginacion);
}

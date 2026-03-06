package com.luisu404.challenge_forohub.repository;

import com.luisu404.challenge_forohub.domain.perfil.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}

package com.eventos.eventos.repositories;

import com.eventos.eventos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> findByDescricao(String descricao);
}

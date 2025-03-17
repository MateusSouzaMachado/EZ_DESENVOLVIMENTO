package com.eventos.eventos.repositories;

import com.eventos.eventos.models.Produtora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoraRepository extends JpaRepository<Produtora, Long> {
    Optional<Produtora> findByCpfCnpj(String cpfCnpj);
    Optional<Produtora> findByNome(String nome);
}

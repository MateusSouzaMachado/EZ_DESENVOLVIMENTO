package com.eventos.eventos.service;

import com.eventos.eventos.dtos.ProdutoraDTO;
import com.eventos.eventos.dtos.UsuarioDTO;
import com.eventos.eventos.models.Produtora;
import com.eventos.eventos.models.Usuario;
import com.eventos.eventos.repositories.ProdutoraRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ProdutoraService {


    @Autowired
    private ProdutoraRepository produtoraRepository;

    public ProdutoraDTO salvarProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = new Produtora(produtoraDTO);
        return new ProdutoraDTO(produtoraRepository.save(produtora));
    }

    public Produtora buscarProdutoraPorId(Long id) {
        return produtoraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produtora não encontrado"));
    }

    public ProdutoraDTO atualizarProdutora(ProdutoraDTO produtoraDTO) {
        if (isNull(produtoraDTO.getId())) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        Produtora produtora = produtoraRepository.findById(produtoraDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Produtora não encontrado"));
        produtora = new Produtora(produtoraDTO);
        produtoraRepository.save(produtora);
        return new ProdutoraDTO(produtora);
    }

    public void deletarProdutora(Long id) {
        produtoraRepository.deleteById(id);
    }

    public ProdutoraDTO buscarProdutoraPorNome(String nome) {
        return new ProdutoraDTO(produtoraRepository.findByNome(nome).orElseThrow(() -> new IllegalArgumentException("Produtora não encontrado")));
    }

    public ProdutoraDTO buscarProdutoraPorCpfCnpj(String cpfCnpj) {
        return new ProdutoraDTO(produtoraRepository.findByCpfCnpj(cpfCnpj).orElseThrow(() -> new IllegalArgumentException("Produtora não encontrado")));
    }

}



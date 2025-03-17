package com.eventos.eventos.service;

import com.eventos.eventos.dtos.CidadeDTO;
import com.eventos.eventos.dtos.UsuarioDTO;
import com.eventos.eventos.models.Cidade;
import com.eventos.eventos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));
    }

    public CidadeDTO buscarUsuarioPorNome(String nome) {
        return new CidadeDTO(cidadeRepository.findByNome(nome).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada")));
    }

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade(cidadeDTO);
        return new CidadeDTO(cidadeRepository.save(cidade));
    }

    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO) {
        if (isNull(cidadeDTO.getId())) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        Cidade cidade = cidadeRepository.findById(cidadeDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));
        cidade = new Cidade(cidadeDTO);
        cidadeRepository.save(cidade);
        return new CidadeDTO(cidade);
    }

    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
}

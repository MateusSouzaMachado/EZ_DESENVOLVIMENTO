package com.eventos.eventos.dtos;

import com.eventos.eventos.models.Cidade;
import com.eventos.eventos.models.Endereco;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EnderecoDTO {

    private Long id;
    private String numero;
    private String bairro;
    private String estado;
    private String cep;
    private CidadeDTO cidadeDTO;

    public EnderecoDTO() {}

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
        this.cidadeDTO = new CidadeDTO(endereco.getCidade());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CidadeDTO getCidade() {
        return cidadeDTO;
    }

    public void setCidade(CidadeDTO cidadeDTO) {
        this.cidadeDTO = cidadeDTO;
    }
}

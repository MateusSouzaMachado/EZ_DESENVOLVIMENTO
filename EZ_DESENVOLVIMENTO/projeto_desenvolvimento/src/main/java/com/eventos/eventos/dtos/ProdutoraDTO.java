package com.eventos.eventos.dtos;

import com.eventos.eventos.models.Produtora;

public class ProdutoraDTO {
    private Long id;
    private String nome;
    private String cpfCnpj;

    public ProdutoraDTO() {}

    public ProdutoraDTO(Produtora produtora) {
        this.id = produtora.getId();
        this.nome = produtora.getNome();
        this.cpfCnpj = produtora.getCpfCnpj();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}

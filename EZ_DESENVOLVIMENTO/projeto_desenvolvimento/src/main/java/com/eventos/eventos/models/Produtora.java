package com.eventos.eventos.models;

import com.eventos.eventos.dtos.ProdutoraDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_produtoras")
public class Produtora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    public Produtora() {}

    public Produtora(Long id, String nome, String cpfCnpj) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public Produtora(ProdutoraDTO produtoraDTO) {
        this.id = produtoraDTO.getId();
        this.nome = produtoraDTO.getNome();
        this.cpfCnpj = produtoraDTO.getCpfCnpj();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produtora produtora = (Produtora) o;
        return Objects.equals(id, produtora.id) && Objects.equals(nome, produtora.nome) && Objects.equals(cpfCnpj, produtora.cpfCnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpfCnpj);
    }
}

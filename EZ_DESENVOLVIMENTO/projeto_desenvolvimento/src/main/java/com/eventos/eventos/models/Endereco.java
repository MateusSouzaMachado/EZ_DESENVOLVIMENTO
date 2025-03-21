package com.eventos.eventos.models;

import com.eventos.eventos.dtos.EnderecoDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String bairro;
    private String estado;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;



    public Endereco() {
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.numero = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
        this.cidade = new Cidade(enderecoDTO.getCidade());
    }

    public Endereco(Long id, String numero, String bairro, String estado, String cep, Cidade cidade) {
        this.id = id;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
        this.cidade = cidade;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(numero, endereco.numero) && Objects.equals(bairro, endereco.bairro) && Objects.equals(estado, endereco.estado) && Objects.equals(cep, endereco.cep) && Objects.equals(cidade, endereco.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, bairro, estado, cep, cidade);
    }
}

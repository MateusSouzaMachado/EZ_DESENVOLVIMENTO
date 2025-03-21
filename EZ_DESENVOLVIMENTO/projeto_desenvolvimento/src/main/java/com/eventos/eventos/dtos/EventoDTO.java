package com.eventos.eventos.dtos;

import com.eventos.eventos.enums.Classificacao;
import com.eventos.eventos.models.Evento;
import com.eventos.eventos.models.Produtora;


import java.util.Date;

public class EventoDTO {

    private Long id;
    private Date data;
    private String descricao;
    private String horaInicio;
    private String horaFim;
    private String horaAbertura;
    private String imagem;
    private Classificacao classificacao;
    private ProdutoraDTO produtoraDTO;

    public EventoDTO() {
    }

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.data = evento.getData();
        this.descricao = evento.getDescricao();
        this.horaInicio = evento.getHoraInicio();
        this.horaFim = evento.getHoraFim();
        this.horaAbertura = evento.getHoraAbertura();
        this.imagem = evento.getImagem();
        this.classificacao = evento.getClassificacao();
        this.produtoraDTO = new ProdutoraDTO(evento.getProdutora());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public ProdutoraDTO getProdutora() {
        return produtoraDTO;
    }

    public void setProdutora(ProdutoraDTO produtoraDTO) {
        this.produtoraDTO = produtoraDTO;
    }

}

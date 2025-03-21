package com.eventos.eventos.service;

import com.eventos.eventos.dtos.EventoDTO;
import com.eventos.eventos.models.Evento;
import com.eventos.eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento buscarEventoPorId(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Evento não encontrada"));
    }

    public EventoDTO buscarEventoPorDescricao(String descricao) {
        return new EventoDTO(eventoRepository.findByDescricao(descricao).orElseThrow(() -> new IllegalArgumentException("Evento não encontrada")));
    }

    public EventoDTO salvarEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento(eventoDTO);
        return new EventoDTO(eventoRepository.save(evento));
    }

    public EventoDTO atualizarEvento(EventoDTO eventoDTO) {
        if (isNull(eventoDTO.getId())) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        Evento evento = eventoRepository.findById(eventoDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Evento não encontrada"));
        evento = new Evento(eventoDTO);
        eventoRepository.save(evento);
        return new EventoDTO(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}

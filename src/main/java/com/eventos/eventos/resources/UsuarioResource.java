package com.eventos.eventos.resources;

import com.eventos.eventos.dtos.UsuarioDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @GetMapping("/")
    public String getUsuarios() {
        return "testar retorno dos Usuarios";
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioDTO);
    }
}

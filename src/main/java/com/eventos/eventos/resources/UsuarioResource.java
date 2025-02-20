package com.eventos.eventos.resources;

import com.eventos.eventos.dtos.UsuarioDTO;

import com.eventos.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String getUsuarios() {
        return "testar retorno dos Usuarios";
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }


}

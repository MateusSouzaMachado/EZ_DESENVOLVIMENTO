package com.eventos.eventos.resources;

import com.eventos.eventos.dtos.UsuarioDTO;

import com.eventos.eventos.models.Usuario;
import com.eventos.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok( usuarioService.salvarUsuario(usuarioDTO));
    }




}

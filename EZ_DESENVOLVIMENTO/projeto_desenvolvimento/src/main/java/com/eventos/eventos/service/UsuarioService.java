package com.eventos.eventos.service;

import com.eventos.eventos.dtos.UsuarioDTO;
import com.eventos.eventos.models.Usuario;
import com.eventos.eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

//    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
//        Usuario usuario = converterUsuarioDTOParaUsuario(usuarioDTO);
//        usuario = usuarioRepository.save(usuario);
//        return converterUsuarioParaUsuarioDTO(usuario);
//    }
//
//    private Usuario converterUsuarioDTOParaUsuario(UsuarioDTO usuarioDTO) {
//        Usuario usuario = new Usuario();
//        usuario.setId(usuarioDTO.getId());
//        usuario.setNome(usuarioDTO.getNome());
//        usuario.setEmail(usuarioDTO.getEmail());
//        usuario.setSenha(usuarioDTO.getSenha());
//        usuario.setCpf(usuarioDTO.getCpf());
//        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
//        usuario.setPerfil(usuarioDTO.getPerfil());
//        usuario.setVerificado(usuarioDTO.getVerificado());
//        return usuario;
//    }
//
//    public UsuarioDTO converterUsuarioParaUsuarioDTO(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setId(usuario.getId());
//        usuarioDTO.setNome(usuario.getNome());
//        usuarioDTO.setEmail(usuario.getEmail());
//        usuarioDTO.setSenha(usuario.getSenha());
//        usuarioDTO.setCpf(usuario.getCpf());
//        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
//        usuarioDTO.setPerfil(usuario.getPerfil());
//        usuarioDTO.setVerificado(usuario.getVerificado());
//        return usuarioDTO;
//    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return new UsuarioDTO(usuarioRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        if (isNull(usuarioDTO.getId())) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        usuario = new Usuario(usuarioDTO);
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

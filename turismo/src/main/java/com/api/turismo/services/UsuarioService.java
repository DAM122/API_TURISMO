package com.api.turismo.services;

import com.api.turismo.model.Usuario;
import com.api.turismo.repositories.IUsuarioRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepoitory usuarioRepoitory;

    @Transactional
    public List<Usuario> getUsuarios(){
        return usuarioRepoitory.findAll();
    }

    @Transactional
    public Optional<Usuario> getUsuarioById(Long id){
        return  usuarioRepoitory.findById(id);
    }

    @Transactional
    public Optional<Usuario> findByNicknameAndPassword(String nickname, String password) {
        return usuarioRepoitory.findByNicknameAndPassword(nickname, password);
    }

    @Transactional
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        return usuarioRepoitory.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setApellido1(usuarioDetails.getApellido1());
            usuario.setApellido2(usuarioDetails.getApellido2());
            usuario.setPassword(usuarioDetails.getPassword());
            usuario.setNickname(usuarioDetails.getNickname());
            usuario.setPerfil(usuarioDetails.getPerfil());
            return usuarioRepoitory.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepoitory.save(usuario);
    }
}

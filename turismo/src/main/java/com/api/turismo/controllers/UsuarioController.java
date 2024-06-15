package com.api.turismo.controllers;

import com.api.turismo.model.Usuario;
import com.api.turismo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable("id") Long id){
        return this.usuarioService.getUsuarioById(id);
    }

    @GetMapping("/authenticate")
    public Optional<Usuario> authenticate(@RequestParam("nickname") String nickname, @RequestParam("password") String password) {
        return  usuarioService.findByNicknameAndPassword(nickname, password);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioDetails);
        return ResponseEntity.ok(updatedUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(newUsuario);
    }

}

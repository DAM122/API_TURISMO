package com.api.turismo.controllers;

import com.api.turismo.model.Comentario;
import com.api.turismo.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> getComentarios(){
        return this.comentarioService.getComentarios();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Comentario>> getComentariosPorUsuario(@PathVariable Long idUsuario) {
        List<Comentario> comentariosUsuario = comentarioService.getComentariosPorUsuario(idUsuario);
        return new ResponseEntity<>(comentariosUsuario, HttpStatus.OK);
    }

    @GetMapping("/media-puntuacion")
    public ResponseEntity<List<Object[]>> getMediaPuntuacionComentarios() {
        List<Object[]> mediaPuntuacionPorMonumento = comentarioService.getMediaPuntuacionPorMonumento();
        return new ResponseEntity<>(mediaPuntuacionPorMonumento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario nuevoComentario) {
        Comentario comentarioCreado = comentarioService.crearComentario(nuevoComentario);
        return new ResponseEntity<>(comentarioCreado, HttpStatus.CREATED);
    }
}

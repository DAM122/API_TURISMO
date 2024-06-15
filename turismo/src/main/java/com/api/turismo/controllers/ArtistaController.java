package com.api.turismo.controllers;

import com.api.turismo.model.Artista;
import com.api.turismo.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<Artista> getArtistas(){return this.artistaService.getArtistas();}

    @GetMapping(path = "/{id}")
    public Optional<Artista> getArtistas(@PathVariable("id") Long id){
        return this.artistaService.getArtistaById(id);
    }
}

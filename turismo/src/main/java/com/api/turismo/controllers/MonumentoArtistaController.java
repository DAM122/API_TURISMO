package com.api.turismo.controllers;

import com.api.turismo.model.MonumentoArtista;
import com.api.turismo.services.MonumentoArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monumentos-artistas")
public class MonumentoArtistaController {

    @Autowired
    private MonumentoArtistaService monumentoArtistaService;

    @GetMapping
    public List<MonumentoArtista> getMonumentosArtistas(){
        return this.monumentoArtistaService.getMonumentosArtistas();
    }

    @GetMapping("/por-id")
    public Optional<MonumentoArtista> getMonumentoArtista(@RequestParam("id") Long id){
        return this.monumentoArtistaService.getMonumentosArtistasById(id);
    }

    @GetMapping(path = "/{id_monumeto}")
    public MonumentoArtista getMonumentoArtistaByMonumento(@PathVariable("id_monumeto")Long id_monumeto){
        return this.monumentoArtistaService.getMonumentosArtistasByMonumento(id_monumeto);
    }
}

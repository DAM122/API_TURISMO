package com.api.turismo.controllers;

import com.api.turismo.model.Perfil;
import com.api.turismo.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("perfiles")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @GetMapping(path = "/{id}")
    public Optional<Perfil> getPerfilById(@PathVariable("id") long id){
        return this.perfilService.getPefilById(id);
    }
}

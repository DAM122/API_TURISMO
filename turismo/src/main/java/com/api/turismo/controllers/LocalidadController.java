package com.api.turismo.controllers;

import com.api.turismo.model.Localidad;
import com.api.turismo.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {
    @Autowired
    private LocalidadService localidadService;

    @GetMapping
    public List<Localidad> getLocalidades(){
       return this.localidadService.getLocalidades();
    }
}

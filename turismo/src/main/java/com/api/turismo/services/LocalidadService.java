package com.api.turismo.services;

import com.api.turismo.model.Localidad;
import com.api.turismo.repositories.ILocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService {
    @Autowired
    private ILocalidadRepository localidadRepository;

    public List<Localidad> getLocalidades(){
        return this.localidadRepository.findAll();
    }
}

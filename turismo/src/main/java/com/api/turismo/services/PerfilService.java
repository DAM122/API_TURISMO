package com.api.turismo.services;

import com.api.turismo.model.Perfil;
import com.api.turismo.repositories.IPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    public Optional<Perfil> getPefilById(Long id){
        return this.perfilRepository.findById(id);
    }
}

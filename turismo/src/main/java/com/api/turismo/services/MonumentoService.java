package com.api.turismo.services;

import com.api.turismo.repositories.IMonumentoRepository;
import com.api.turismo.model.Monumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonumentoService {

    @Autowired
    private IMonumentoRepository monumentoRepository;
    @Transactional
    public List<Monumento> getMonumentos(){
        return monumentoRepository.findAll();
    }
    @Transactional
    public Monumento getMonumentoByName(String monumento){
        return this.monumentoRepository.findByNombre(monumento);
    }

    @Transactional
    public List<Monumento> searchMonumentosByNombre(String nombre) {
        return this.monumentoRepository.findAllByNombre(nombre);
    }

    @Transactional
    public List<Monumento> getMonumentosByLocalidadId(Long localidadId) {
        return monumentoRepository.findAllByLocalidadId(localidadId);
    }
}

package com.api.turismo.services;

import com.api.turismo.model.MonumentoArtista;
import com.api.turismo.repositories.IMonumentoArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoArtistaService {

    @Autowired
    private IMonumentoArtistaRepository monumentoArtistaRepository;

    @Transactional
    public List<MonumentoArtista> getMonumentosArtistas(){
        return  this.monumentoArtistaRepository.findAll();
    }

    @Transactional
    public Optional<MonumentoArtista> getMonumentosArtistasById(Long id){
        return this.monumentoArtistaRepository.findById(id);
    }

    @Transactional
    public MonumentoArtista getMonumentosArtistasByMonumento(Long id){
        return this.monumentoArtistaRepository.findByMonumentoId(id);
    }

}

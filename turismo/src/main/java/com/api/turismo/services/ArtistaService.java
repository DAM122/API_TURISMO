package com.api.turismo.services;

import com.api.turismo.model.Artista;
import com.api.turismo.repositories.IArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private IArtistaRepository artistaRepository;

    @Transactional
    public List<Artista> getArtistas(){return this.artistaRepository.findAll();}

    @Transactional
    public Optional<Artista> getArtistaById(Long id){return this.artistaRepository.findById(id);}
}

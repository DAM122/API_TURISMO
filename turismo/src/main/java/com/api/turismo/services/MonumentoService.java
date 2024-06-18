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

    @Transactional
    public Monumento saveMonumento(Monumento monumento) {
        return monumentoRepository.save(monumento);
    }
    @Transactional
    public void deleteMonumento(Long id) {
        monumentoRepository.deleteById(id);
    }

    @Transactional
    public Monumento updateMonumento(Long id, Monumento newMonumento) {
        return monumentoRepository.findById(id).map(monumento -> {
            monumento.setNombre(newMonumento.getNombre());
            monumento.setFecha(newMonumento.getFecha());
            monumento.setEstilo(newMonumento.getEstilo());
            monumento.setDescripcion(newMonumento.getDescripcion());
            monumento.setVisitable(newMonumento.isVisitable());
            monumento.setParking(newMonumento.isParking());
            monumento.setTelefono(newMonumento.getTelefono());
            monumento.setImagen(newMonumento.getImagen());
            monumento.setValoracion(newMonumento.getValoracion());
            monumento.setLocalidad(newMonumento.getLocalidad());
            return monumentoRepository.save(monumento);
        }).orElseGet(() -> {
            newMonumento.setId(id);
            return monumentoRepository.save(newMonumento);
        });
    }
}

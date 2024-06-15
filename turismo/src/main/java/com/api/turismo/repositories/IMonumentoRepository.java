package com.api.turismo.repositories;

import com.api.turismo.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMonumentoRepository extends JpaRepository<Monumento,Long> {
    Monumento findByNombre(String nombre);

    List<Monumento> findAllByNombre(String nombre);

    List<Monumento> findAllByLocalidadId(Long localidadId);
}

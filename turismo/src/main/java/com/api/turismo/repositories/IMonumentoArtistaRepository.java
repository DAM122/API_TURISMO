package com.api.turismo.repositories;

import com.api.turismo.model.MonumentoArtista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonumentoArtistaRepository extends JpaRepository<MonumentoArtista,Long> {
    MonumentoArtista findByMonumentoId(Long monumentId);
}

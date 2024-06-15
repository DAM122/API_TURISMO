package com.api.turismo.repositories;

import com.api.turismo.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistaRepository extends JpaRepository<Artista,Long> {
}

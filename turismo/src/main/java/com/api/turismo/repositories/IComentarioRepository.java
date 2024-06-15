package com.api.turismo.repositories;

import com.api.turismo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario,Long> {
    List<Comentario> findAllByUsuarioId(Long idUsuario);
}

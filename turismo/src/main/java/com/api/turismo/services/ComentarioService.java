package com.api.turismo.services;

import com.api.turismo.model.Comentario;
import com.api.turismo.repositories.IComentarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public List<Comentario> getComentarios(){
        return this.comentarioRepository.findAll();
    }

    @Transactional
    public Comentario crearComentario(Comentario nuevoComentario) {
        return comentarioRepository.save(nuevoComentario);
    }

    @Transactional(readOnly = true)
    public List<Comentario> getComentariosPorUsuario(Long idUsuario) {
        return comentarioRepository.findAllByUsuarioId(idUsuario);
    }
    @Transactional(readOnly = true)
    public List<Object[]> getMediaPuntuacionPorMonumento() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Comentario> root = criteriaQuery.from(Comentario.class);

        criteriaQuery.multiselect(root.get("monumento"), criteriaBuilder.avg(root.get("puntuacion")));
        criteriaQuery.groupBy(root.get("monumento"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

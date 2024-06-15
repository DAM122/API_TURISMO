package com.api.turismo.repositories;

import com.api.turismo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepoitory extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByNicknameAndPassword(String nickname, String password);
}

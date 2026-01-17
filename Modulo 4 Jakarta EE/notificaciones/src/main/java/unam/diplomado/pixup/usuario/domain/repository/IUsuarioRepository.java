package unam.diplomado.pixup.usuario.domain.repository;

import unam.diplomado.pixup.usuario.domain.Usuario;

import java.util.Optional;

public interface IUsuarioRepository {

    Optional<Usuario> finByEmail(String email);
}

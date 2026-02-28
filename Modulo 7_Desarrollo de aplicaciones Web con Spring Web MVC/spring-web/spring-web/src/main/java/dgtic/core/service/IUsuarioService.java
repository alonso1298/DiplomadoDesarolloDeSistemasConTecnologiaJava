package dgtic.core.service;

import dgtic.core.model.entity.UsuarioBd;

import java.util.List;

public interface IUsuarioService {
    void guardar(UsuarioBd usuario);
    List<UsuarioBd> todosUsuarios();
}

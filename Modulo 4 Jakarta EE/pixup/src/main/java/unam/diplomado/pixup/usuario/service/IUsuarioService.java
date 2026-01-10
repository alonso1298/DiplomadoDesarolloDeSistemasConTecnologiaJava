package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;

@Local // No obligamos que le consumo sea par auna aplicacion en java
public interface IUsuarioService {

    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}

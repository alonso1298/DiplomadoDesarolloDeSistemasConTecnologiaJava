package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.repository.IColoniaReposritory;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.repository.IDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.ITipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.IUsuarioRepository;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements IUsuarioService{

    @Inject
    private IDomicilioRepository domicilioRepository;
    @Inject
    private IUsuarioRepository usuarioRepository;
    @Inject
    private ITipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    private IColoniaReposritory coloniaReposritory;

    @Override
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        // validacion usuario duplicado (unicidad)
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()){

        }
        return null;
    }
}

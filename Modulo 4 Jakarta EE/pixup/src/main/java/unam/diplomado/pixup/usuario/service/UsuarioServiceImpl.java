package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoudException;
import unam.diplomado.pixup.colonia.repository.IColoniaReposritory;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.IDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.ITipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.IUsuarioRepository;

import java.util.Optional;
import java.util.Timer;

@Stateless
public class UsuarioServiceImpl implements IUsuarioService {

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
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }
        // Valida colonia
        Optional<Colonia> coloniaExistente = coloniaReposritory.findById(domicilio.getColonia().getId());
        if (coloniaExistente.isEmpty()) {
            throw new ColoniaNotFoudException(domicilio.getColonia().getId());
        }
        domicilio.setColonia(coloniaExistente.get());
        // Valida tipoDomicilio
        Optional<TipoDomicilio> tipoDomicilioExistente =
                tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if (tipoDomicilioExistente.isEmpty()) {
            throw new TipoDomicilioNotFoudException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilioExistente.get());

        // persistencia / guardado de entidades
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        return usuario;
    }
}

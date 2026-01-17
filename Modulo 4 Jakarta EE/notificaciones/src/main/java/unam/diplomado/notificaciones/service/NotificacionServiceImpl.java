package unam.diplomado.notificaciones.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.notificaciones.domain.Notificacion;
import unam.diplomado.notificaciones.domain.TipoNotificacion;
import unam.diplomado.notificaciones.domain.TipoNotificacionNotFoundException;
import unam.diplomado.notificaciones.domain.repository.INotificacionRepository;
import unam.diplomado.notificaciones.domain.repository.ITipoNotificacionRepository;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.domain.UsuarioNotFoundException;
import unam.diplomado.pixup.usuario.repository.IUsuarioRepository;

import java.util.Optional;

@Stateless
public class NotificacionServiceImpl implements INotificacionService{

    @Inject
    private IEmailSerivce emailSerivce;
    @Inject
    private INotificacionRepository notificacionRepository;
    @Inject
    private ITipoNotificacionRepository tipoNotificacionRepository;
    @Inject
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Notificacion enviarNotificacionAltaUsuario(Integer idUsuario, String email) {
        String descTipoNotificacion = "ALTA_USUARIO";
        String emailTitulo = "Creación de cuenta " + email + " exitosa";
        String emailMensaje = "<h1>Pixup</h1><h3>" +
                "La cuenta " + email + " fue creada exitosamente</h3>";

        Notificacion notificacion = new Notificacion();
        // Existe usuario
        Optional<Usuario> usuario = usuarioRepository.finByEmail(email);
        if (usuario.isEmpty()){
            throw  new UsuarioNotFoundException(email);
        }
        notificacion.setUsuario(usuario.get());

        Optional<TipoNotificacion> tipoNotificacion = tipoNotificacionRepository.findByDescripcion(descTipoNotificacion);
        if (tipoNotificacion.isEmpty()){
            throw new TipoNotificacionNotFoundException(descTipoNotificacion);
        }
        notificacion.setTipoNotificacion(tipoNotificacion.get());

        notificacionRepository.save(notificacion);
        emailSerivce.enviarEmail(email, emailTitulo, emailMensaje);

        return notificacion;
    }
}

package dgtic.core.service;

import dgtic.core.model.entity.UsuarioBd;
import dgtic.core.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private final IUsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void guardar(UsuarioBd usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioBd> todosUsuarios() {
        return usuarioRepository.findAll();
    }
}

package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.IArtistaRepository;
import unam.diplomado.pixup.disco.repository.IDiscoRepository;
import unam.diplomado.pixup.disco.repository.IDisqueraRepository;
import unam.diplomado.pixup.disco.repository.IGeneroMusicalRepository;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistsException;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements IDiscoService{

    @Inject
    private IDisqueraRepository disqueraRepository;
    @Inject
    private IArtistaRepository artistaRepository;
    @Inject
    private IGeneroMusicalRepository generoMusicalRepository;
    @Inject
    private IDiscoRepository discoRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Disco registrarDisco(Disco disco) {
        // Validar disquera
        Optional<Disquera> disqueraExistente = disqueraRepository.findById(disco.getDisquera().getId());
        if (disqueraExistente.isEmpty()) {
            throw new DisqueraNotFoundException(disqueraExistente.get().getId());
        }
        disco.setDisquera(disqueraExistente.get());
        // Valisa Artista
        Optional<Artista> artistaExistente = artistaRepository.finById(disco.getArtista().getId());
        if (artistaExistente.isEmpty()){
            throw new ArtistaNotFoudException(disco.getArtista().getId());
        }
        disco.setArtista(artistaExistente.get());
        // Valida genero musical
        Optional<GeneroMusical> generoMusicalExistente = generoMusicalRepository.findById(disco.getGeneroMusical().getId());
        if (generoMusicalExistente.isEmpty()) {
            throw new GeneroMusicalNotFoundException(generoMusicalExistente.get().getId());
        }
        disco.setGeneroMusical(generoMusicalExistente.get());
        // Validar duplicidad
        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        if (discoExistente.isPresent()){
            throw new DiscoDuplicadoNotFoundException(disco.getTitulo(), disco.getArtista().getNombre());
        }

        return discoRepository.save(disco);
    }
}

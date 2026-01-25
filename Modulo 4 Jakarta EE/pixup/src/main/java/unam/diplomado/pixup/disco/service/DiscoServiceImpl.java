package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.repository.IArtistaRepository;
import unam.diplomado.pixup.disco.repository.IDiscoRepository;
import unam.diplomado.pixup.disco.repository.IDisqueraRepository;
import unam.diplomado.pixup.disco.repository.IGeneroMusicalRepository;

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
    public Disco registrarDisco(Disco disco) {
        return disco;
    }
}

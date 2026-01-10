package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreradyExistsException;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoudException;
import unam.diplomado.pixup.colonia.domain.Municipio;
import unam.diplomado.pixup.colonia.domain.MunicipioNotFoundException;
import unam.diplomado.pixup.repository.IColoniaReposritory;
import unam.diplomado.pixup.repository.IMunicipioRepositoryImpl;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements IColoniaService {

    @Inject
    private IColoniaReposritory coloniaRepository;
    @Inject
    private IMunicipioRepositoryImpl municipioRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        throw new ColoniaNotFoudException(id);
    }

    @Override
    public Colonia crearColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente =
            coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente.isPresent()) {
            throw new ColoniaAlreradyExistsException(colonia.getCp(), colonia.getNombre());
        }

        Optional<Municipio> municipíoExistente =
            municipioRepository.findById(colonia.getMunicipio().getId());
        if (municipíoExistente.isEmpty()) {
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }
        colonia.setMunicipio(municipíoExistente.get());

        coloniaRepository.saveOrUpdate(colonia);
        return colonia;
    }

    @Override
    public Colonia actualizarColonia(Colonia colonia) {
        return null;
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {

    }
}

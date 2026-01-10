package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.*;
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
        Optional<Colonia> coloniaExistente = coloniaRepository.findById(colonia.getId());
        if (coloniaExistente.isEmpty()) {
            throw new ColoniaNotFoudException(colonia.getId());
        }

        Optional<Colonia> coloniaExistente2 =
                coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente2.isPresent()) {
            throw new ColoniaAlreradyExistsException(colonia.getCp(), colonia.getNombre());
        }

        Optional<Municipio> municipioExistente =
                municipioRepository.findById(colonia.getMunicipio().getId());
        if (municipioExistente.isEmpty()) {
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }

        Colonia coloniaActualizar = coloniaExistente.get();
        coloniaActualizar.setMunicipio(municipioExistente.get());
        coloniaActualizar.setNombre(colonia.getNombre());
        coloniaActualizar.setCp(colonia.getCp());

        coloniaRepository.saveOrUpdate(coloniaActualizar);
        return coloniaActualizar;
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
        /*
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()){
            coloniaRepository.delete(colonia.get());
        }
        */
        coloniaRepository.findById(id)
                .ifPresent(colonia -> coloniaRepository.delete(colonia));
    }
}

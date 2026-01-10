package unam.diplomado.pixup.colonia.service;

import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IColoniaService {

    Colonia obtenerColoniaPorId(Integer id);
    Colonia crearColonia(Colonia colonia);
    Colonia actualizarColonia(Colonia colonia);
    void eliminarColoniaPorId(Integer id);

}

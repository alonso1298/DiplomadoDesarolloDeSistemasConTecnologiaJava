package unam.diplomado.pixup.repository;

import java.util.Optional;

import unam.diplomado.pixup.colonia.domain.Municipio;

public interface IMunicipioRepository {
    
     Optional<Municipio> findById(Integer id);

}

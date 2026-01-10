package unam.diplomado.pixup.repository;

import java.util.Optional;

import unam.diplomado.pixup.colonia.domain.Municipio;

public interface IMunicipioRepositoryImpl {
    
     Optional<Municipio> findById(Integer id);

}

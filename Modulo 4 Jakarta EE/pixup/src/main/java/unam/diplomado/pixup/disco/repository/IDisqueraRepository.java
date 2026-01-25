package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Disquera;

import java.util.Optional;

public interface IDisqueraRepository {
    Optional<Disquera> findById(Integer id);
}

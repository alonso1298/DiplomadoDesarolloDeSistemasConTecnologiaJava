package unam.diplomado.pixup.disco.repository;

import java.util.Optional;

public interface IDisqueraRepository {
    Optional<Disquera> finById(Integer id);
}

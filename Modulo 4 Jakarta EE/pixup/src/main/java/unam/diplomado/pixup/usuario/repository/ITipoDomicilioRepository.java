package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

public interface ITipoDomicilioRepository {

    Collection<TipoDomicilio> findAll();
    TipoDomicilio findById(Integer id);

}

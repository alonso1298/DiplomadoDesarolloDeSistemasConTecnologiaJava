package unam.diplomado.pixup.usuario.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.repository.ITipoDomicilioRepository;

import java.util.Collection;

@RequestScoped // Cada que llegue una petition o un hilo de ejecución al servidor web la información de entrada y salida es distinta
public class TipoDomicilioResource implements ITipoDomicilioApi{

    @Inject // Le dice al contenedor que debe inyectar una dependencia una referencia a una clase que implemente la interfaz ITipoDomicilioRepository
    private ITipoDomicilioRepository tipoDomicilioRepository; // Composicion de objetos

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
}

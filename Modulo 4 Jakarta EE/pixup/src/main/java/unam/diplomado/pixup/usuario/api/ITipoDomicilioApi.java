package unam.diplomado.pixup.usuario.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON) // Si se envie un parametro es de mediaType
@Produces(MediaType.APPLICATION_JSON)
@Path("tiposDomicilio")
public interface ITipoDomicilioApi {

    @GET
    Collection<TipoDomicilio> getAll();
}

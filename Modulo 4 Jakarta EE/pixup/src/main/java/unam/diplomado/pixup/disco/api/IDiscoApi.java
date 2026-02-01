package unam.diplomado.pixup.disco.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("discos")
public interface IDiscoApi {

    @POST
    @Path("alta")
    Response altaDisco(@NotNull @Valid DiscoRequestDTO disco);

}
package unam.diplomado.pixup.colonia.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("colonias")
public interface IColoniaApi {

    @GET
    @Path("{id}")
    Response getColoniaById(@PathParam("id") Integer id); //@PathParam("id") liga el valor para hacer la busqueda correspondiente
    
    @GET
    Collection<Colonia> getColoniasByCp(@NotBlank @QueryParam("cp") String cp); // @QueryParam("cp") hace el ligado del valor
      // @NotBlank por medio de la anotacion se puede aplicar validaciones en este caso que el valor no venga en blanco

    @DELETE
    @Path("{id}")
    void deleteColonia(@PathParam("id") Integer id);

    @POST
    Response createColonia(@NotNull @Valid Colonia colonia);

    @PUT
    @Path("{id}")
    void updateColonia(@PathParam("id") Integer id, Colonia colonia);

}

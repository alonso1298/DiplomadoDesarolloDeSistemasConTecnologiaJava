package unam.diplomado.pixup.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.DiscoDuplicadoException;
import unam.diplomado.pixup.disco.domain.DisqueraNotFoundException;
import unam.diplomado.pixup.disco.service.IDiscoService;

@RequestScoped
public class DiscoResource implements IDiscoApi {

    @Inject
    private IDiscoService discoService;

    @Override
    public Response altaDisco(Disco disco) {
        // Validar disco si ya existe
        try {
            Disco nuevo = discoService.registrarDisco(disco);
            return Response.status(Response.Status.CREATED) // Codigo 201
                    .entity(nuevo)
                    .build();
        }catch (DiscoDuplicadoException e){
            return Response.status(Response.Status.CONFLICT) // Codigo 409
                    .entity("El disco ya existe: " + e.getMessage())
                    .build();

        } catch (DisqueraNotFoundException e) { // Valida Disquera
            return Response.status(422) // Unprocessable Content
                    .entity("Disquera no encontrada: " + e.getMessage())
                    .build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST) // Codigo 400
                    .entity("Datos invalidos: " + e.getMessage())
                    .build();
        }catch (Exception e) {
            return Response.serverError()
                    .entity("Error interno: " + e.getMessage())
                    .build();
        }
    }

}

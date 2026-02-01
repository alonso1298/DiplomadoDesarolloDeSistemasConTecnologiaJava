package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DiscoDuplicadoException;

@Provider
public class DiscoExistenteExceptionMapper implements ExceptionMapper<DiscoDuplicadoException> {

    @Override
    public Response toResponse(DiscoDuplicadoException e) {
        return Response.status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
